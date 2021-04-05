package pe.com.starcode.testprojectbase.general.di.modules.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import pe.com.starcode.testprojectbase.general.data.source.local.AppDatabase
import pe.com.starcode.testprojectbase.general.utils.Constants
import javax.inject.Singleton

@Module
class DatabaseModule {

//    @Provides
//    fun provideUserDao(RoomDatabase: RoomDatabase): UserDao {
//        return RoomDatabase.userDao()
//    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, Constants.NAME_DB)
            .fallbackToDestructiveMigration()
            .build()
    }
}