package com.peculiaruc.alc_mmsystem_mentormanager.ui.profile.editProfile

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.chip.Chip
import com.google.android.material.textfield.TextInputLayout
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.ChipDto
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.DocumentDto
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.RoleDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentEditProfileBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.DocumentsAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.DocumentsProfileAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.util.CompressUtil
import com.peculiaruc.alc_mmsystem_mentormanager.util.MyPermissions
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.IOException
import java.io.InputStream

/**
 * This fragment is used for the user to edit his/her profile
 */
class EditProfileFragment : Fragment() {

    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: EditProfileViewModel

    private var imageBody: MultipartBody.Part? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[EditProfileViewModel::class.java]


        Glide.with(this)
            .load("https://images.unsplash.com/photo-1632765854612-9b02b6ec2b15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1886&q=80")
            .circleCrop()
            .placeholder(R.drawable.ic_user_avater)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageViewProfileImg)

        val fakeCountries = listOf("Egypt", "Libya", "Ghana", "Cameron")
        val adapterCountries = ArrayAdapter(requireContext(), R.layout.list_item, fakeCountries)
        binding.dropdownCountry.setAdapter(adapterCountries)

        val fakeCities = listOf("Cairo", "Kazanlak", "Khartoum", "Alex")
        val adapterCities = ArrayAdapter(requireContext(), R.layout.list_item, fakeCities)
        binding.dropdownCity.setAdapter(adapterCities)

        binding.buttonSelectFile.setOnClickListener {
            val cameraPermissions = arrayOf(Manifest.permission.CAMERA)
            if (!MyPermissions.isPermissionsGranted(requireActivity(), cameraPermissions)) {
                MyPermissions.requestPermissionFragment(
                    this,
                    cameraPermissions,
                    1
                )
            } else {
                openImageChooserIntent()
            }
        }

        binding.buttonSaveProfile.setOnClickListener {
            findNavController().navigate(EditProfileFragmentDirections.actionEditMyProfileFragmentToProfileFragment())
        }

        val chipsTechnicality = listOf(
            ChipDto(1, "Python"), ChipDto(2, "Java"), ChipDto(3, "Kotlin"),
            ChipDto(4, "Django"), ChipDto(5, "JavaScript"), ChipDto(6, "My SQL"),
            ChipDto(6, "Android"), ChipDto(6, "Swift"), ChipDto(6, "C++"),
        )

        val chipsRules = listOf(
            RoleDto(1, "Learner"), RoleDto(2, "Mentor"), RoleDto(3, "Program Assistant"),
            RoleDto(4, "Program Assistant Lead"), RoleDto(5, "Mentor Manager"),
        )
        chipsTechnicality.forEach {
            val chip = layoutInflater.inflate(
                R.layout.custom_chip_choice,
                binding.chipGroupTechnicalProficiency,
                false
            ) as Chip
            chip.text = it.name

            binding.chipGroupTechnicalProficiency.addView(chip)
        }

        chipsRules.forEach {
            val chip = layoutInflater.inflate(
                R.layout.custom_chip_choice,
                binding.chipGroupPreviousRolesHeld,
                false
            ) as Chip
            chip.text = it.name

            binding.chipGroupPreviousRolesHeld.addView(chip)
        }

        val fakeDocs = listOf(
            DocumentDto(1, "Myresume.pdf"),
            DocumentDto(2, "my certificate.doc"),
            DocumentDto(3, "my certificate2.doc"),
        )

        val documentAdapter = DocumentsAdapter {

        }

        val documentsProfileAdapter = DocumentsProfileAdapter {

        }

        binding.recyclerViewDocuments.adapter = documentAdapter

        documentAdapter.submitList(fakeDocs)
        documentsProfileAdapter.submitList(fakeDocs)

        addProgramView()
        addProgramView()

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigate(EditProfileFragmentDirections.actionEditMyProfileFragmentToProfileFragment())
        }

        binding.buttonPreviousPrograms.setOnClickListener {
            addProgramView()
        }

        return binding.root
    }

    @SuppressLint("InflateParams")
    private fun addProgramView() {
        val view = layoutInflater.inflate(R.layout.program_edit_text_layout, null, false)
        val textInputLayout = view.findViewById<TextInputLayout>(R.id.outlinedTextField_programs1)
        textInputLayout.setEndIconOnClickListener {
            removeView(view)
        }
        binding.linearLayoutProgramsHeld.addView(view)
    }

    private fun removeView(view: View?) {
        binding.linearLayoutProgramsHeld.removeView(view)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri: Uri? = data.data
            imageUri?.let { uri ->
                try {
                    val imageStream: InputStream? =
                        requireActivity().contentResolver.openInputStream(uri)
                    val imageBitmap = BitmapFactory.decodeStream(imageStream)
                    setUserImageBitmap(imageBitmap)
                } catch (ex: IOException) {
                    Log.e("EditProfileFragment", "Exception: ${ex.stackTrace}")
                }
            }
        }
    }

    private fun setUserImageBitmap(imageBitmap: Bitmap?) {
        if (imageBitmap != null) {
            try {
                val imageFile = CompressUtil.compressBitmap(imageBitmap, requireContext())

                val requestFile = imageFile.asRequestBody("image/*".toMediaTypeOrNull())
                imageBody = MultipartBody.Part.createFormData("image", imageFile.name, requestFile)

                Glide.with(this).load(imageFile)
                    .circleCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.imageViewProfileImg)

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }


    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if ((requestCode == 1) && grantResults.isNotEmpty()) {
            var isAllAccepted = true
            for (grantResult in grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    isAllAccepted = false
                    break
                }
            }
            if (isAllAccepted) {
                openImageChooserIntent()
            }
        }
    }

    private fun openImageChooserIntent() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        this.startActivityForResult(intent, 2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}