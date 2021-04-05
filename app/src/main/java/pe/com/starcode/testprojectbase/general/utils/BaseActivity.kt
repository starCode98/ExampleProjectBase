package pe.com.starcode.testprojectbase.general.utils

import android.content.Context
import android.content.ContextWrapper
import dagger.android.DaggerActivity

open class BaseActivity : DaggerActivity() {

    override fun attachBaseContext(newBase: Context) {
// get chosen language from shread preference
        val localeToSwitchTo = LocaleHelper.getAppLanguageLocale(newBase)
        val localeUpdatedContext: ContextWrapper =
            LocaleHelper.updateLocale(newBase, localeToSwitchTo)
        super.attachBaseContext(localeUpdatedContext)
    }
}