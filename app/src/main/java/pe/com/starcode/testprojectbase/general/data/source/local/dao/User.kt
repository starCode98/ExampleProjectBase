package pe.com.starcode.testprojectbase.general.data.source.local.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User {
    @PrimaryKey
    var id:Int=0
}