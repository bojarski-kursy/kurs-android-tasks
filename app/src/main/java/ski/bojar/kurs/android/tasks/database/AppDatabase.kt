package ski.bojar.kurs.android.tasks.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ski.bojar.kurs.android.tasks.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}