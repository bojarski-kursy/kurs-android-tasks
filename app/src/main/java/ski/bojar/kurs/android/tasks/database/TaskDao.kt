package ski.bojar.kurs.android.tasks.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ski.bojar.kurs.android.tasks.model.Task

@Dao
interface TaskDao {

    @Insert
    suspend fun insert(task: Task)

    @Query("SELECT * FROM task")
    suspend fun getAll(): List<Task>
}