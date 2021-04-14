package pe.com.starcode.testprojectbase.general.di.modules.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pe.com.starcode.testprojectbase.MainActivity

@Module(includes = [FragmentModule::class])
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}