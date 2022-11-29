package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile.mentor_list
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorListBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile.mentor_list_adapter
import java.util.*
import javax.activation.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart


class Mentor_list_Fragment : Fragment() {
    private var _binding:FragmentMentorListBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvAdapter: mentor_list_adapter
    private lateinit var mentorLists :ArrayList<mentor_list>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        _binding = FragmentMentorListBinding.inflate(inflater, container, false)
        //  Load dummy data on the mentors list
        load_mentors_dummy_list()
        //  search mentor and share functionality
         binding.reportToolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
            addMenuProvider(object : MenuProvider{
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.mentor_menu_item, menu)
                }
                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    // below line is to get our menu item.
                    val searchItem: MenuItem = menu.findItem(R.id.app_bar_search)
                    // getting search view of our item.
                    val searchView: SearchView = searchItem.getActionView() as SearchView
                    // below line is to call set on query text listener method.
                    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                        android.widget.SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(p0: String?): Boolean {
                            return false
                        }
                        override fun onQueryTextChange(msg: String): Boolean {
                            // inside on query text change method we are
                            // calling a method to filter our recycler view.
                            filter(msg)
                            return false
                        }
                    })
                    return true
                }
            })
        }
        // intialize mentor filter spinner and assign it values
        val spinner: Spinner = binding.MentorsSpinner
        val mList = arrayOf<String?>("All Mentors", "Assigned", "Unassigned")
        // Create an adapter  for the spinner
        val mArrayAdapter = context?.let { ArrayAdapter<Any?>(it, R.layout.spinner_list_item, mList) }
        mArrayAdapter?.setDropDownViewResource(R.layout.spinner_list_item)
        // Display spinner on click of the  filtter dropdown button
        binding.pagetitle.setOnClickListener {
            Toast.makeText(context, "i am clicked", Toast.LENGTH_SHORT).show()
            if (spinner.getVisibility() == View.VISIBLE) {
                spinner.setVisibility(View.VISIBLE);
                spinner.performClick()
            } else {
                spinner.setVisibility(View.GONE);
            }
        }
        // Respond to selection of item in a spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.body1.setText(mList.get(position));
                if (mList.get(position)=="Assigned"){
                    sort_mentors(true)
                }
                else if(mList.get(position)=="Unassigned"){
                    sort_mentors(false)
                }
                else{
                    val mentor_recyleview=binding.mentorsRv
                    mentor_recyleview.getAdapter()?.notifyItemInserted(mentorLists.size );
                    mentor_recyleview.getAdapter()?.notifyDataSetChanged();
                    mentor_recyleview.setHasFixedSize(true);
                    mentor_recyleview.setLayoutManager(LinearLayoutManager(requireView().getContext()));
                    mentor_recyleview.setAdapter(mentor_list_adapter(mentorLists))
                }
                spinner.setVisibility(View.GONE);
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // populate the mentors recyclerview with list of all mentros
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        binding.mentorsRv.setLayoutManager(layoutManager)
        rvAdapter = mentor_list_adapter(mentorLists)
        binding.mentorsRv.adapter = rvAdapter
        // add new mentor
        binding.carbonAdd.setOnClickListener {
            val dialogadd_mentor = layoutInflater.inflate(R.layout.alert_dialog_box_add_mentor, null)
            val dialog_confirmsend = layoutInflater.inflate(R.layout.alert_dialog_box_done_adding_mentor, null)
            //display the add mentor dialog box
            val customDialog = context?.let { it1 -> AlertDialog.Builder(it1).setView(dialogadd_mentor).show() }
          // on click of cancel button close the dialog box
            val btn_add_mentor_dialog_cancel = dialogadd_mentor.findViewById<RelativeLayout>(R.id.frame_352)
            btn_add_mentor_dialog_cancel.setOnClickListener { if (customDialog != null) { customDialog.dismiss() } }
            // on click of send button opend the confirm_send dialog box the
            val btnsend = dialogadd_mentor.findViewById<RelativeLayout>(R.id.frame_351)

            btnsend.setOnClickListener {

                val thread = Thread {
                    val m = Mail("ngundiben1@gmail.com", "Ben@2022")
                    val toArr = arrayOf("ben@kinde.co.ke","ngundiben@gmail.com")
                    m.setTo(toArr)
                    m.setFrom("ngundiben1@gmail.com")
                    m.setSubject("This is an email sent using my Mail JavaMail wrapper from an Android device.")
                    m.body = "Email body."


                    try {
                        //Your code goes here
                        if (m.send()) {
                            Toast.makeText(context, "Email was sent successfully.", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(context, "Email was not sent.", Toast.LENGTH_LONG).show()
                        }

                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()

                        //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
                        Log.e("MailApp", "Could not send email", e)
                    }
                }

                thread.start()



            }


        }
    }
    private fun sort_mentors(text: Boolean) {
        val filteredlist = ArrayList<mentor_list>()
        for (item in mentorLists) {
            if (item.assignne?.equals(text)==true) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(context, "No Data Found..", Toast.LENGTH_SHORT).show()
            val mentor_recyleview=binding.mentorsRv
            mentor_recyleview.getAdapter()?.notifyItemInserted(mentorLists.size );
            mentor_recyleview.getAdapter()?.notifyDataSetChanged();
            mentor_recyleview.setHasFixedSize(true);
            mentor_recyleview.setLayoutManager(LinearLayoutManager(requireView().getContext()));
            mentor_recyleview.setAdapter(mentor_list_adapter( filteredlist))

        } else {
            val mentor_recyleview=binding.mentorsRv
            mentor_recyleview.getAdapter()?.notifyItemInserted(mentorLists.size );
            mentor_recyleview.getAdapter()?.notifyDataSetChanged();
            mentor_recyleview.setHasFixedSize(true);
            mentor_recyleview.setLayoutManager(LinearLayoutManager(requireView().getContext()));
            mentor_recyleview.setAdapter(mentor_list_adapter( filteredlist))
        }
    }

    private fun load_mentors_dummy_list() {

        mentorLists = arrayListOf(
            mentor_list(
                "Peculiar C. Umeh",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann,
                true
            ),
            mentor_list(
                "Mohammend J. Hassan",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann_2,
                false
            ),
            mentor_list(
                "Ombasanjo R. Uke",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.grace,
                true
            ),
            mentor_list(
                "James Karim Michael",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.profile,
                false,
            ),
            mentor_list(
                "Josep K Ndururro",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann_2,
                true,
            ),
            mentor_list(
                "Abdul Hassan Mohamed",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann,
                false
            ),
            mentor_list(
                "MiKe Njoronge Macharia",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.profile,
                true
            ),
            mentor_list(
                "Pendo Karisa Haddassah",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.grace,
                false
            ),
            mentor_list(
                "Peculiar C. Umeh",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann,
                true
            ),
            mentor_list(
                "Mohammend J. Hassan",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann_2,
                false
            ),
            mentor_list(
                "Ombasanjo R. Uke",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.grace,
                true
            ),
            mentor_list(
                "James Karim Michael",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.profile,
                false
            ),
            mentor_list(
                "Josep K Ndururro",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann_2,
                true
            ),
            mentor_list(
                "Abdul Hassan Mohamed",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann,
                false
            ),
            mentor_list(
                "MiKe Njoronge Macharia",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.profile,
                true
            ),
            mentor_list(
                "Pendo Karisa Haddassah",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.grace,
                false
            ),
            mentor_list(
                "Peculiar C. Umeh",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann,
                true
            ),
        )

    }

    private fun filter(text: String) {
        val filteredlist = ArrayList<mentor_list>()
        for (item in mentorLists) {
            if (item.name?.toLowerCase()?.contains(text.lowercase(Locale.getDefault())) == true) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(context, "No Data Found..", Toast.LENGTH_SHORT).show()
            val mentor_recyleview=binding.mentorsRv
            mentor_recyleview.getAdapter()?.notifyItemInserted(mentorLists.size );
            mentor_recyleview.getAdapter()?.notifyDataSetChanged();
            mentor_recyleview.setHasFixedSize(true);
            mentor_recyleview.setLayoutManager(LinearLayoutManager(requireView().getContext()));
            mentor_recyleview.setAdapter(mentor_list_adapter( filteredlist))

        } else {
            val mentor_recyleview=binding.mentorsRv
            mentor_recyleview.getAdapter()?.notifyItemInserted(mentorLists.size );
            mentor_recyleview.getAdapter()?.notifyDataSetChanged();
            mentor_recyleview.setHasFixedSize(true);
            mentor_recyleview.setLayoutManager(LinearLayoutManager(requireView().getContext()));
            mentor_recyleview.setAdapter(mentor_list_adapter( filteredlist))
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class Mail() : Authenticator() {
    private var _user = ""
    private var _pass = ""
    private lateinit var _to: Array<String>
    private var _from = ""
    private val _port = "465"
    private val _sport = "465"
    private val _host = "smtp.gmail.com"
    private var _subject = ""

    // the getters and setters
    var body = ""
    private val _auth = true
    private val _debuggable = false
    private val _multipart: Multipart



    init {
        // default smtp server
        // default smtp port
        // default socketfactory port
        // username
        // password
        // email sent from
        // email subject
        // email body
        // debug mode on or off - default off
        // smtp authentication - default on
        _multipart = MimeMultipart()

        // There is something wrong with MailCap, javamail can not find a handler for the multipart/mixed part, so this bit needs to be added.
        val mc = CommandMap.getDefaultCommandMap() as MailcapCommandMap
        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html")
        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml")
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain")
        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed")
        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822")
        CommandMap.setDefaultCommandMap(mc)
    }

    constructor(user: String, pass: String) : this() {
        _user = user
        _pass = pass
    }

    @Throws(Exception::class)
    fun send(): Boolean {
        val props = _setProperties()
        return if (_user != "" && _pass != "" && _to.size > 0 && _from != "" && _subject != "" && body != "") {
            val session = Session.getInstance(props, this)
            val msg = MimeMessage(session)
            msg.setFrom(InternetAddress(_from))
            val addressTo = arrayOfNulls<InternetAddress>(_to.size)
            for (i in _to.indices) {
                addressTo[i] = InternetAddress(_to[i])
            }
            msg.setRecipients(MimeMessage.RecipientType.TO, addressTo)
            msg.subject = _subject
            msg.sentDate = Date()

            // setup message body
            val messageBodyPart: BodyPart = MimeBodyPart()
            messageBodyPart.setText(body)
            _multipart.addBodyPart(messageBodyPart)

            // Put parts in message
            msg.setContent(_multipart)

            // send email
            Transport.send(msg)
            true
        } else {
            false
        }
    }

    @Throws(Exception::class)
    fun addAttachment(filename: String?) {
        val messageBodyPart: BodyPart = MimeBodyPart()
        val source: DataSource = FileDataSource(filename)
        messageBodyPart.dataHandler = DataHandler(source)
        messageBodyPart.fileName = filename
        _multipart.addBodyPart(messageBodyPart)
    }

    public override fun getPasswordAuthentication(): PasswordAuthentication {
        return PasswordAuthentication(_user, _pass)
    }

    private fun _setProperties(): Properties {
        val props = Properties()
        props["mail.smtp.host"] = _host
        if (_debuggable) {
            props["mail.debug"] = "true"
        }
        if (_auth) {
            props["mail.smtp.auth"] = "true"
        }
        props["mail.smtp.port"] = _port
        props["mail.smtp.socketFactory.port"] = _sport
        props["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory"
        props["mail.smtp.socketFactory.fallback"] = "false"
        return props
    }

    fun setTo(toArr: Array<String>) {
        // TODO Auto-generated method stub
        _to = toArr
    }

    fun setFrom(string: String) {
        // TODO Auto-generated method stub
        _from = string
    }

    fun setSubject(string: String) {
        // TODO Auto-generated method stub
        _subject = string
    } // more of the getters and setters …..
}


