package d7man.ristogreen.digital.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import d7man.ristogreen.digital.data.dao.GameRecordDao
import d7man.ristogreen.digital.data.database.converter.Converters
import d7man.ristogreen.digital.data.entity.GameRecord

@Database(
    entities = [GameRecord::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class DIRILAppDatabase : RoomDatabase() {

    abstract fun gameRecordDao(): GameRecordDao
}