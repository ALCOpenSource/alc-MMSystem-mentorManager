package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.peculiaruc.alc_mmsystem_mentormanager.R

/**
 * MMM-Team-7
 * Custom adapter for the report screen spinner
 */

class SpinnerAdapter(context: Context, list: ArrayList<String>)
    : ArrayAdapter<String>(context, 0, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var currentItemView = convertView
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(context).inflate(R.layout.drop_down_spinner, parent, false)
        }
        val item = getItem(position)
        val text = currentItemView?.findViewById<TextView>(R.id.textView6)
        if (item != null) {
            text?.text = item
        }

        return currentItemView!!
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var currentItemView = convertView
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(context).inflate(R.layout.drop_down_item, parent, false)
        }
        val item = getItem(position)
        val text = currentItemView?.findViewById<TextView>(R.id.textView5)
        if (item != null) {
            text?.text = item
        }

        return currentItemView!!
    }
}