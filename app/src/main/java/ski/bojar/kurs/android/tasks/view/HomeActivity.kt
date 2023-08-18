package ski.bojar.kurs.android.tasks.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ski.bojar.kurs.android.tasks.model.Task

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val welcomeValue: String? = intent.getStringExtra("welcome_value")
        val task = intent.getSerializableExtra("task") as? Task
        task?.let {
            Toast.makeText(this, "task: $task", Toast.LENGTH_LONG).show()
        }

        setContent {
            //HomeText(welcomeValue)
            HomeView()
        }
    }

    @Composable
    fun HomeView() {
        val context = LocalContext.current
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            FloatingActionButton(
                onClick = {
                    val intent = Intent(context, TaskActivity::class.java)
                    startActivity(intent)
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