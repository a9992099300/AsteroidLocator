package com.a9992099300.asteroidlocator.core_impl.shared_preference

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.a9992099300.asteroidlocator.core_api.domain.entities.AppPreference
import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidPreferences
import com.a9992099300.asteroidlocator.core_api.domain.entities.Language
import javax.inject.Inject
const val TAG = "debug"
internal class AsteroidPreferencesImpl @Inject constructor(context: Context) : AsteroidPreferences {
    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

     //   .setOnPreferenceChangeListener
    override suspend fun loadAppPreference(): AppPreference {
        val prefTheme = sharedPreferences.getBoolean(PREFERENCES_THEME, false)
        Log.d(TAG, "preference PreferencesImpl $prefTheme")
        val prefLanguage = sharedPreferences.getString(PREFERENCES_LANGUAGE, null)
            ?.let { Language.valueOf(it) }  ?: Language.DEFAULT
        return AppPreference(prefTheme, prefLanguage)
    }

    override suspend fun saveTheme(blackTheme: Boolean) {
        sharedPreferences.edit {
            putBoolean(PREFERENCES_THEME, blackTheme)
            Log.d(TAG, "blackTheme impl $blackTheme")
        }
    }

    override suspend fun saveLanguage(language: Language) {
        sharedPreferences.edit {
            putString(PREFERENCES_LANGUAGE, language.name)
        }
    }

    companion object {
        private const val PREFERENCES_LANGUAGE = "language"
        private const val PREFERENCES_THEME = "theme"
    }

}