package pe.com.starcode.testprojectbase.general.utils

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import dagger.android.DaggerActivity

open class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
// get chosen language from shread preference
        val localeToSwitchTo = LocaleHelper.getAppLanguageLocale(newBase)
        val localeUpdatedContext: ContextWrapper =
            LocaleHelper.updateLocale(newBase, localeToSwitchTo)
        super.attachBaseContext(localeUpdatedContext)
    }
}