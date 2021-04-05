package pe.com.starcode.testprojectbase.application

import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import pe.com.starcode.testprojectbase.general.di.component.DaggerAppComponent
import timber.log.Timber

class AppBase : DaggerApplication() {


    private val applicationInjector = DaggerAppComponent.builder().application(this).build()
    //    //
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return applicationInjector
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(applicationContext)


        //init logs
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }

}