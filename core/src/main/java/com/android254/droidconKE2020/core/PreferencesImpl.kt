package com.android254.droidconKE2020.core

import android.content.Context
import android.content.SharedPreferences
import com.android254.droidconKE2020.core.di.Constants.SHARED_PREF_FILE_NAME

class PreferencesImpl(context: Context): Preferences {

    override val sharedPref: SharedPreferences = context
        .getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)

    private fun editSharedPref(action: (s: SharedPreferences.Editor) -> Unit) {
        with (sharedPref.edit()) {
            action(this)
            apply()
        }
    }

//    override fun getUserName(defaultValue: String): String? {
//        return sharedPref.getString("userName", defaultValue)
//    }
//
//    override fun setUserName(username: String) {
//        editSharedPref {
//            it.putString("userName", username)
//        }
//    }
}