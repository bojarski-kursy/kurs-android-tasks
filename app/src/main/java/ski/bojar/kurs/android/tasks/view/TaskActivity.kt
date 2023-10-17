package ski.bojar.kurs.android.tasks.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.viewmodel.ext.android.viewModel
import ski.bojar.kurs.android.tasks.R
import ski.bojar.kurs.android.tasks.model.ColorType
import ski.bojar.kurs.android.tasks.model.Task
import ski.bojar.kurs.android.tasks.model.TaskOperationStatus
import ski.bojar.kurs.android.tasks.ui.theme.Blue
import ski.bojar.kurs.android.tasks.ui.theme.TasksTheme
import ski.bojar.kurs.android.tasks.viewmodel.TaskViewModel

class TaskActivity : ComponentActivity() {

    val taskViewModel by viewModel<TaskViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val editTask: Task? = intent.getSerializableExtra("edit_task") as? Task

        setContent {
            TasksTheme() {
                Surface(Modifier.fillMaxSize()) {
                    TaskView(editTask)
                    ObserveAddTaskStatus()
                }
            }
        }
    }

    @Composable
    private fun ObserveAddTaskStatus() {
        when (taskViewModel.addEditTaskStatus) {
            TaskOperationStatus.SUCCESS -> {
                val intent = Intent(this, HomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                finish()
            }
            TaskOperationStatus.ERROR -> {
                Toast.makeText(
                    this, 
                    stringResource(id = R.string.info_connection_problem),
                    Toast.LENGTH_LONG
                ).show()
            }
            TaskOperationStatus.LOADING, TaskOperationStatus.UNKNOWN -> {}
        }
    }

    @Composable
    fun TaskView(editTask: Task?) {
        val context = LocalContext.current
        val taskColors = ColorType.values()

        var currentColor by rememberSaveable {
            mutableStateOf(editTask?.colorType ?: taskColors.first())
        }
        var titleText by rememberSaveable { mutableStateOf(editTask?.title ?: "") }
        var descriptionText by rememberSaveable { mutableStateOf(editTask?.description ?: "") }
        
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = stringResource(id = R.string.task), fontSize = 30.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = currentColor.color),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)
            ) {
                val outlinedTextStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
                val outlinedTextFieldColors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = Blue,
                    unfocusedLabelColor = Color.Gray
                )

                OutlinedTextField(
                    value = titleText, // taskViewModel.titleText
                    onValueChange = { titleText = it }, // taskViewModel.titleText
                    label = { Text(text = stringResource(id = R.string.title)) },
                    textStyle = outlinedTextStyle,
                    colors = outlinedTextFieldColors,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                OutlinedTextField(
                    value = descriptionText,
                    onValueChange = { descriptionText = it },
                    label = { Text(text = stringResource(id = R.string.description)) },
                    textStyle = outlinedTextStyle,
                    colors = outlinedTextFieldColors,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            val selectedButtonBorderColor = if (isSystemInDarkTheme()) Color.White else Color.Gray
            LazyRow() {
                items(items = taskColors) { colorType ->
                    Button(
                        onClick = { currentColor = colorType},
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = colorType.color),
                        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 8.dp),
                        border = BorderStroke(2.dp, if (currentColor == colorType) selectedButtonBorderColor else colorType.color),
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(40.dp)
                    ) { }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (editTask == null) {
                        val task = Task(
                            title = titleText,
                            description = descriptionText,
                            colorType = currentColor
                        )
                        taskViewModel.addTask(task)
                    } else {
                        val task = editTask.copy(
                            title = titleText,
                            description = descriptionText,
                            colorType = currentColor
                        )
                        taskViewModel.editTask(task)
                    }
                }
            ) {
                if (taskViewModel.addEditTaskStatus == TaskOperationStatus.LOADING) {
                    CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp))
                } else {
                    Text(text = stringResource(id = R.string.save))
                }
            }

            Image(painter = painterResource(R.drawable.task_image), contentDescription = null)
//            val imageUrl = "https://img.freepik.com/free-vector/completed-concept-illustration_114360-2945.jpg?w=1060&t=st=1697552718~exp=1697553318~hmac=f1595f7825b495b957044cc380da3f31f35e34027d9df8be610168ea15a2d42c"
//            AsyncImage(model = imageUrl, contentDescription = null)
        }
    }
}
















