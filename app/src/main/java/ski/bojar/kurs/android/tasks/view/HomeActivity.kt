package ski.bojar.kurs.android.tasks.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.viewmodel.ext.android.viewModel
import ski.bojar.kurs.android.tasks.model.TaskOperationStatus
import ski.bojar.kurs.android.tasks.viewmodel.TaskViewModel

//var taskList = mutableListOf<Task>()

class HomeActivity : ComponentActivity() {

//    val taskDatabaseRepository by inject<TaskDatabaseRepository>()
//    val taskNetworkRepository by inject<TaskNetworkRepository>()
    val taskViewModel by viewModel<TaskViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MyTasksApp", "HomeActivity onCreate()")

        taskViewModel.getAllTasks()

        //taskList = StorageOperations.readTaskList(this).toMutableList()
        /*
        getAllTasksViaNetwork()

        //val welcomeValue: String? = intent.getStringExtra("welcome_value")
        val task = intent.getSerializableExtra("task") as? Task
        task?.let {
            //Toast.makeText(this, "task: $task", Toast.LENGTH_LONG).show()
            //Log.d("MyTasksApp", "task: $task")

            taskList.add(task)
            //StorageOperations.writeTaskList(this, taskList)
            insertTaskToDatabase(task)

            addTaskViaNetwork(task)
        }
        */

        setContent {
            //HomeText(welcomeValue)
            HomeView()
            observeGetAllTasksStatus()
        }
    }

    private fun observeGetAllTasksStatus() {
        if (taskViewModel.getAllTasksStatus == TaskOperationStatus.ERROR) {
            Toast.makeText(this, "Tasks loaded from local storage", Toast.LENGTH_LONG).show()
        }
    }

/*
    private fun insertTaskToDatabase(task: Task) {
        runBlocking {
            taskDatabaseRepository.insertTask(task)
        }
    }

    private fun insertAllTasksToDatabase(taskList: List<Task>) {
        runBlocking {
            taskDatabaseRepository.insertAllTasks(taskList)
        }
    }

    private fun getAllTasksFromDatabase() {
        runBlocking {
            taskList = taskDatabaseRepository.getAllTasks().toMutableList()
        }
    }

    private fun getAllTasksViaNetwork() {
        val context = this

        runBlocking {
            try {
                taskList = taskNetworkRepository.getAllTasks().toMutableList()
                //StorageOperations.writeTaskList(context, taskList)
                insertAllTasksToDatabase(taskList)
            } catch (e: Exception) {
                Log.e("MyTasksApp", "Network get all tasks: $e")
                //taskList = StorageOperations.readTaskList(context).toMutableList()
                getAllTasksFromDatabase()
                Toast.makeText(context, "Tasks loaded from local storage", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun addTaskViaNetwork(task: Task) {
        val context = this

        runBlocking {
            try {
                taskNetworkRepository.addTask(task)
            } catch (e: Exception) {
                Log.e("MyTasksApp", "Network add task: $e")
                Toast.makeText(context, "Connection problem. Try again.", Toast.LENGTH_LONG).show()
            }
        }
    }
*/
    @Composable
    fun TaskListView() {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text(
                text = "Task list",
                fontSize = 30.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = taskViewModel.taskList) { task ->
                    Card(
                        colors = CardDefaults.cardColors(containerColor = task.colorType.color),
                        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = task.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = task.description,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                }
            }
        }
    }

    @Composable
    fun HomeView() {
        val context = LocalContext.current
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            when (taskViewModel.getAllTasksStatus) {
                TaskOperationStatus.SUCCESS, TaskOperationStatus.ERROR -> {
                    if (taskViewModel.taskList.isEmpty()) {
                        Text(
                            text = "Empty task list",
                            fontSize = 20.sp,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    } else {
                        TaskListView()
                    }
                }
                TaskOperationStatus.LOADING -> CircularProgressIndicator(Modifier.align(Alignment.Center))
                TaskOperationStatus.UNKNOWN -> {}
            }


            FloatingActionButton(
                onClick = {
                    val intent = Intent(context, TaskActivity::class.java)
                    startActivity(intent)

                    finish()
                },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add task")
            }
        }
    }

    @Composable
    fun HomeText(value: String?) {
        Text(text = value ?: "Witaj w domu!")
    }
}