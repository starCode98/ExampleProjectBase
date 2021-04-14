package pe.com.starcode.testprojectbase.general.di.modules.main

import android.content.Context
import android.content.res.Resources
import dagger.Binds
import dagger.Module
import dagger.Provides
import pe.com.starcode.testprojectbase.application.AppBase
import pe.com.starcode.testprojectbase.general.di.modules.network.NetworkModule
import pe.com.starcode.testprojectbase.general.di.modules.vm.ViewModelModule
import pe.com.starcode.testprojectbase.general.di.modules.db.DatabaseModule
import pe.com.starcode.testprojectbase.general.utils.DialogMessageHelper
import pe.com.starcode.testprojectbase.general.utils.SharedPreferencesManager
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, ActivityModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: AppBase): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideResources(application: AppBase): Resources = application.resources

    //preferences
    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferencesManager {
        return SharedPreferencesManager(context)
    }



}