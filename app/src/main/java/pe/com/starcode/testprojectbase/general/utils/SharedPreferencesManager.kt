package pe.com.starcode.testprojectbase.general.utils

import android.content.Context
import javax.inject.Inject

class SharedPreferencesManager@Inject constructor(
    private val context: Context

)  {

    private val sharedPreferences by lazy{
        context.getSharedPreferences(
            Constants.SharedPreferences.PREF_NAME,
            Context.MODE_PRIVATE
        )
    }
    fun getString(preferenceName: String, defaultValue: String): String {
        return sharedPreferences.getString(
            preferenceName,
            defaultValue
        )!!
    }

}