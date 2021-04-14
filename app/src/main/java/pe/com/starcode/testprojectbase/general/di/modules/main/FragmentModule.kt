package pe.com.starcode.testprojectbase.general.di.modules.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pe.com.starcode.testprojectbase.movies.presentation.MoviesFragment

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMoviesFragment(): MoviesFragment
}