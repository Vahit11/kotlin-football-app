package com.vahitkeskin.kotlinfootballapp.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.vahitkeskin.kotlinfootballapp.util.Constants.Companion.PREFERENCES_THEME_MODE_NAME

class CustomSharedPreferences {

    companion object {
        private var sharedPreferences: SharedPreferences? = null

        @Volatile
        private var instance: CustomSharedPreferences? = null
        private val lock = Any()

        operator fun invoke(context: Context): CustomSharedPreferences = instance ?: synchronized(lock) {
            instance ?: makeCustomSharedPreferences(context).also {
                instance = CustomSharedPreferences()
            }
        }

        private fun makeCustomSharedPreferences(context: Context): CustomSharedPreferences {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharedPreferences()
        }

    }

    fun themeMode(theme: Boolean) {
        sharedPreferences?.edit(commit = true) {
            putBoolean(PREFERENCES_THEME_MODE_NAME,theme)
        }
    }

    fun getThemeMode() = sharedPreferences?.getBoolean(PREFERENCES_THEME_MODE_NAME,false)

}