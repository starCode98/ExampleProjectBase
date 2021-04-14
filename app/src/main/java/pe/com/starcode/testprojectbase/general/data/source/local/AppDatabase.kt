package pe.com.starcode.testprojectbase.general.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.com.starcode.testprojectbase.general.data.source.local.dao.User

/**
 *To manage data items that can be accessed, updated
 * @Created by ESTRELLA
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao
}