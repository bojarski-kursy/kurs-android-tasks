package ski.bojar.kurs.android.tasks.api

import ski.bojar.kurs.android.tasks.model.Task

class TaskNetworkRepository(private val taskService: TaskService) {

    suspend fun addTask(task: Task) {
        taskService.add(task)
    }

    suspend fun getAllTasks(): List<Task> {
        return taskService.getAll().values.toList()
    }
}