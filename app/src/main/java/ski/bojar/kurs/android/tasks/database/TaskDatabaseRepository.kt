package ski.bojar.kurs.android.tasks.database

import ski.bojar.kurs.android.tasks.model.Task

class TaskDatabaseRepository(private val db: AppDatabase) {

    suspend fun insertTask(task: Task) {
        db.taskDao().insert(task)
    }

    suspend fun insertAllTasks(taskList: List<Task>) {
        db.taskDao().insertAll(taskList)
    }

    suspend fun getAllTasks(): List<Task> {
        return db.taskDao().getAll()
    }

    suspend fun deleteTask(task: Task) {
        db.taskDao().delete(task)
    }

    suspend fun editTask(task: Task) {
        db.taskDao().edit(task)
    }

}