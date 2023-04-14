package ski.bojar.kurs.android.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyModifier()
        }
    }

    @Composable
    fun MyModifier() {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
//                .fillMaxHeight()
//                .fillMaxWidth()
                .fillMaxSize()
//                .height(100.dp)
//                .width(200.dp)
//                .size(height = 100.dp, width = 200.dp)
//                .padding(50.dp)
//                .padding(top = 16.dp, bottom = 32.dp, start = 4.dp, end = 64.dp)
//                .padding(horizontal = 16.dp)
                .padding(vertical = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Testujemy opcje dostępne w Modifier",
                modifier = Modifier
                    .width(75.dp)
//                    .background(Color.Cyan, CircleShape) // RectangleShape, CircleShape, RoundedCornerShape, CutCornerShape
//                    .clip(CircleShape)
                    .background(Color.Cyan)
                    .padding(8.dp)
                    .rotate(45f)
                    .border(2.dp, Color.Blue, RoundedCornerShape(5.dp))
            )
            Text(
                text = "Android",
                modifier = Modifier
                    .rotate(45f)
                    .background(Color.Red)
                    .padding(20.dp)
                    .background(Color.Green)
                    .padding(5.dp)
                    .border(1.dp, Color.Black)
                    .background(Color.White)
            )
        }
    }

    @Composable
    fun MyColumnExercise() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Witaj Androidzie!")
            Text(text = "Witaj ponownie!")
            Text(text = "Hej, co u Ciebie?")
        }
    }

    @Composable
    fun MyRow() {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom, // Top, CenterVertically, Bottom
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Witaj Androidzie!")
            Text(text = "Witaj ponownie!")
            Text(text = "Hej, co u Ciebie?")
        }
    }

    @Composable
    fun MyColumn() {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start, // Start, CenterHorizontally, End
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(text = "Witaj Androidzie!")
            Text(text = "Witaj ponownie!")
            Text(text = "Hej, co u Ciebie?")
        }
    }

    @Composable
    fun MyElement() {
        Text(text = "Witaj Androidzie!")
        Text(text = "Witaj ponownie!")
        Text(text = "Hej, co u Ciebie?")
    }
}