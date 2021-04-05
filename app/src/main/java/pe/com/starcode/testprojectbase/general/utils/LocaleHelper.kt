package pe.com.starcode.testprojectbase.general.utils

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import java.util.*

class LocaleHelper(base: Context) : ContextWrapper(base) {

    companion object {

        fun getAppLanguage(context: Context): String {
            val sharedPreferences = SharedPreferencesManager(context)

            val prefLanguage = sharedPreferences.getString(
                Constants.SharedPreferences.PREF_LANGUAGE_SELECTED,
                ""
            )

            return if (prefLanguage.isEmpty()) {
                var defaultLanguage = Locale.getDefault().language

                if (defaultLanguage.isEmpty()) {
                    defaultLanguage = "en"
                }
                defaultLanguage
            } else {
                prefLanguage
            }
        }
        fun getAppLanguageLocale(context: Context): Locale {
            return  Locale(getAppLanguage(context))
        }
        fun updateLocale(c: Context, localeToSwitchTo: Locale): ContextWrapper {
            var context = c
            val resources: Resources = context.resources
            val config: Configuration = resources.configuration
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val localeList = LocaleList(localeToSwitchTo)
                LocaleList.setDefault(localeList)
                config.setLocales(localeList)
            } else {
                config.locale = localeToSwitchTo
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                context = context.createConfigurationContext(config)
            } else {
                resources.updateConfiguration(config, resources.displayMetrics)
            }
            return LocaleHelper(context)
        }
    }
}