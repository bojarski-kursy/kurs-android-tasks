package ski.bojar.kurs.android.tasks.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ski.bojar.kurs.android.tasks.api.TaskNetworkRepository
import ski.bojar.kurs.android.tasks.database.TaskDatabaseRepository
import ski.bojar.kurs.android.tasks.model.Task
import ski.bojar.kurs.android.tasks.model.TaskOperationStatus

class TaskViewModel(
    private val taskDatabaseRepository: TaskDatabaseRepository,
    private val taskNetworkRepository: TaskNetworkRepository
) : ViewModel() {

    var taskList by mutableStateOf(emptyList<Task>())
    var addTaskStatus by mutableStateOf(TaskOperationStatus.UNKNOWN)
    var getAllTasksStatus by mutableStateOf(TaskOperationStatus.UNKNOWN)

    fun getAllTasks() {
        viewModelScope.launch {
            try {
                getAllTasksStatus = TaskOperationStatus.LOADING
                taskList = taskNetworkRepository.getAllTasks().toMutableList()
                taskDatabaseRepository.insertAllTasks(taskList)
                getAllTasksStatus = TaskOperationStatus.SUCCESS
            } catch (e: Exception) {
                taskList = taskDatabaseRepository.getAllTasks()
                getAllTasksStatus = TaskOperationStatus.ERROR
            }
        }
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
            try {
                addTaskStatus = TaskOperationStatus.LOADING
                taskNetworkRepository.addTask(task)
                taskDatabaseRepository.insertTask(task)
                addTaskStatus = TaskOperationStatus.SUCCESS
            } catch (e: Exception) {
                addTaskStatus = TaskOperationStatus.ERROR
            }
        }
    }

}