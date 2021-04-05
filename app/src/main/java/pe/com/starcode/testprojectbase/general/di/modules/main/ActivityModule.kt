package pe.com.starcode.testprojectbase.general.di.modules.main

import dagger.Module

@Module(includes = [FragmentModule::class])
abstract class ActivityModule {

//    @ContributesAndroidInjector
//    abstract fun contributeUserActivity(): UserActivity
}