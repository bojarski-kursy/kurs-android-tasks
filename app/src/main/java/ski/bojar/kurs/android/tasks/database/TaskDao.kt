package ski.bojar.kurs.android.tasks.database

import androidx.room.Dao
import androidx.room.Insert
import ski.bojar.kurs.android.tasks.model.Task

@Dao
interface TaskDao {

    @Insert
    suspend fun insert(task: Task)
}