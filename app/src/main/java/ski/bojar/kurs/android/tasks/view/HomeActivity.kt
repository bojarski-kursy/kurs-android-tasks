package ski.bojar.kurs.android.tasks.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        }
    }

    @Composable
    fun HomeText(value: String?) {
        Text(text = value ?: "Witaj w domu!")
    }
}