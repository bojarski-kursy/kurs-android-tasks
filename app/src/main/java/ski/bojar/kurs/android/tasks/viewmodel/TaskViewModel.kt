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

class TaskViewModel(
    private val taskDatabaseRepository: TaskDatabaseRepository,
    private val taskNetworkRepository: TaskNetworkRepository
) : ViewModel() {

    var taskList by mutableStateOf(emptyList<Task>())

    fun getAllTasks() {
        viewModelScope.launch {
            try {
                taskList = taskNetworkRepository.getAllTasks().toMutableList()
                taskDatabaseRepository.insertAllTasks(taskList)
            } catch (e: Exception) {
                taskList = taskDatabaseRepository.getAllTasks()
            }
        }
    }

}