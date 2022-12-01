package com.peculiaruc.alc_mmsystem_mentormanager

import android.app.Application

/**
 * MMM-Team-7
 * Here we override the application class to create a singleton for the application
 */

class MentorManagerApplication : Application(){

    companion object {
        var global_Var_MENTOR_NAME =""
        var global_Var_MENTOR_NAME_pic =R.drawable.ann_2
        var global_Var_MENTOR_NAME_certificate_name =""
        var global_Var_chat_partner =""
        var global_Var_chat_profile_pic =R.drawable.ann_2

    }
}