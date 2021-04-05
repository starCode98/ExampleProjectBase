package pe.com.starcode.testprojectbase.general.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import pe.com.starcode.testprojectbase.application.AppBase
import pe.com.starcode.testprojectbase.general.di.modules.main.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent: AndroidInjector<AppBase> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: AppBase): Builder

        fun build(): AppComponent
    }

    override fun inject(app: AppBase)
}