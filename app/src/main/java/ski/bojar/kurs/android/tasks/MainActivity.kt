package ski.bojar.kurs.android.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MySurface()
            //MyCard()
            MyBox()
        }
    }

    @Composable
    fun MyBox() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            //contentAlignment = Alignment.BottomEnd
        ) {
            Text(text = "Box1", modifier = Modifier.align(Alignment.BottomEnd))
            Text(text = "Box2", modifier = Modifier.align(Alignment.TopCenter))
            Text(text = "Box3", modifier = Modifier.align(Alignment.BottomStart))

            Box(
                modifier = Modifier
                    .size(150.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .align(Alignment.Center)
                    .padding(10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Magenta, RoundedCornerShape(8.dp))
                        .align(Alignment.TopStart)
                )

                Spacer(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Magenta, RoundedCornerShape(8.dp))
                        .align(Alignment.BottomEnd)
                )

                Spacer(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Red, RoundedCornerShape(8.dp))
                        .align(Alignment.Center)
                )
            }
        }
    }

    @Composable
    fun MyCard() {
        Card(
            modifier = Modifier.padding(20.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors()
        ) {
            Text(
                text = "Card",
                modifier = Modifier.padding(10.dp)
            )
        }
    }

    @Composable
    fun MySurface() {
        Surface(
            contentColor = Color.Blue,
            color = Color.Green,
            border = BorderStroke(2.dp, Color.Red),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Surface",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
    
    @Composable
    fun MyButton() {
        Column() {
            Button(onClick = { }) {
                Text(text = "Button")
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.DarkGray
                ),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.DarkGray),
                contentPadding = PaddingValues(30.dp),
                modifier = Modifier.padding(10.dp),
                enabled = false
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    Text(text = "Add")
                }
            }
            
            OutlinedButton(onClick = {}) {
                Text(text = "Outlined Button")
            }

            TextButton(onClick = { }) {
                Text(text = "Text Button")
            }
        }
    }

    @Composable
    fun MyTextDividerProgressExercise() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Witaj!",
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Thin,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
            )
            Divider()
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Divider()
            Text(
                text = "Fajny ten Twój progress! ;)",
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Composable
    fun MyProgress() {
        Column(modifier = Modifier.padding(10.dp)) {
            CircularProgressIndicator(color = Color.Green)
            CircularProgressIndicator(progress = 0.8f)

            LinearProgressIndicator(
                color = Color.Green,
                modifier = Modifier.fillMaxWidth(),
                trackColor = Color.Red
            )
            Spacer(modifier = Modifier.height(10.dp))
            LinearProgressIndicator(progress = 0.8f)
        }
    }

    @Composable
    fun MyDivider() {
        Column {
            Text(text = "Jestem wyżej")
            Divider(
                color = Color.Red,
                thickness = 5.dp
            )
            Text(text = "A ja niżej")
        }
    }
    
    @Composable
    fun MySpacer() {
        Column() {
            Text(
                text = "Jestem wyżej",
//                modifier = Modifier.padding(bottom = 20.dp)
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
                    .background(Color.Gray)
            )
            Text(text = "A ja niżej")
        }
    }

    @Composable
    fun MyIcon() {
        Column() {
            Icon(imageVector = Icons.Default.Email, contentDescription = "email icon")
            Icon(imageVector = Icons.Outlined.Email, contentDescription = "email icon")
            Icon(imageVector = Icons.Default.Done, contentDescription = "done icon", tint = Color.Green)

            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "done icon",
                tint = Color.White,
                modifier = Modifier
                    .background(Color.Green, CircleShape)
                    .border(1.dp, Color.LightGray, CircleShape)
                    .padding(4.dp)
            )
        }
    }

    @Composable
    fun MyTextAlign() {
        Column(
            modifier = Modifier.fillMaxSize(),
            //horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Text1",
                modifier = Modifier
                    .background(Color.Green)
                    .align(Alignment.End)
                    .fillMaxWidth(),
                textAlign = TextAlign.End
            )
            Text(
                text = "Text2",
                modifier = Modifier
                    .background(Color.Yellow)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Text3",
                modifier = Modifier
                    .background(Color.Red)
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .height(50.dp)
                    .wrapContentSize()
            )
        }
    }

    @Composable
    fun MyText() {
        Text(
            text = "Piszę sobie własny tekst w Text i będę go stylować!",
            fontSize = 20.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.background(Color.Yellow)
        )
    }

    @Composable
    fun MyModifierExercise() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Top",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .background(Color.Gray)
            )
            Text(
                text = "Bottom",
                modifier = Modifier
                    .border(width = 2.dp, color = Color.White, shape = CircleShape)
                    .background(color = Color.LightGray, shape = CircleShape)
                    .padding(10.dp)
            )
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