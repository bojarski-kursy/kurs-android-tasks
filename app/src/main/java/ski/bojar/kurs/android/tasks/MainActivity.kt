package ski.bojar.kurs.android.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MyLazyColumn()
            //MyLazyRow()
            //MyLazyRowItem()
            //MyLazyVerticalGrid()
            //MyLazyColumnClickExercise()
            //MyLazyRowClickExercise()
            MyLazyColumnRowExercise()
        }
    }

    @Composable
    fun MyLazyColumnRowExercise() {
        LazyColumn() {
            items(count = 100) { columnIndex ->
                LazyRow() {
                    items(count = 100) { rowIndex ->
                        MyLazyItem(number = columnIndex * rowIndex)
                    }
                }
            }
        }
    }

    @Composable
    fun MyLazyRowClickExercise() {
        var selectedIndex by remember { mutableStateOf(-1) }

        LazyRow() {
            items(count = 100) { index ->
                Surface(
                    border = BorderStroke(1.dp, Color.Gray),
                    color = if (selectedIndex == index) Color.LightGray else Color.White,
                    modifier = Modifier
                        .clickable { selectedIndex = index }
                ) {
                    Text(text = "$index", modifier = Modifier.padding(10.dp))
                }
            }
        }
    }
    
    @Composable
    fun MyLazyColumnClickExercise() {
        var counter by remember { mutableStateOf(0) }
        val itemList = remember { mutableStateListOf<Int>() }
        
        Column() {
            Button(onClick = { itemList.add(counter++) }) {
                Text(text = "Add")
            }
            LazyColumn() {
                items(items = itemList) { item ->
                    Text(text = "$item")
                }
            }
        }
    }

    @Composable
    fun MyLazyVerticalGrid() {
        LazyVerticalGrid(
            //columns = GridCells.Adaptive(150.dp)
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(count = 100) { index ->
                MyLazyItem(index)
            }
        }
    }

    @Composable
    fun MyLazyRowItem() {
        LazyRow(
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(count = 100) { index ->
                MyLazyItem(index)
            }
        }
    }

    @Composable
    fun MyLazyItem(number: Int) {
        Card(border = BorderStroke(1.dp, Color.DarkGray)) {
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.List, contentDescription = "")
                Text(text = "Tekst $number")
            }
        }
    }

    @Composable
    fun MyLazyRow() {
        val itemList = remember { mutableStateListOf("A", "B", "C") }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            item { Text(text = "Z") }
            items(count = 30) { index ->
                Text(text = "Item $index")
            }
            items(items = itemList) { item ->
                Text(text = "$item")
            }
        }
    }

    @Composable
    fun MyLazyColumn() {
//        Column() {
//            for (i in 0..100) {
//                Text(text = "Item $i")
//            }
//        }

        val itemList = remember { mutableStateListOf(1, 3, 5, 7, 9, 11) }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            //modifier = Modifier.padding(top = 20.dp)
            contentPadding = PaddingValues(top = 20.dp)
        ) {
            item { Text(text = "Item A") }
            item { Text(text = "Item B") }

//            for (i in 0..100) {
//                item { Text(text = "Item $i") }
//            }
            items(count = 100) { index ->
                Text(text = "Item $index")
            }

            items(items = itemList) { item ->
                Text(text = "$item")
            }
        }
    }

    @Composable
    fun MyTextFieldExercise2() {
        var text by remember { mutableStateOf("") }
        var isTextTooLong by remember { mutableStateOf(false) }
        val maxChar = 20

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            TextField(
                value = text,
                onValueChange = { value ->
                    text = value
                    isTextTooLong = text.length > maxChar
                },
                modifier = Modifier.fillMaxWidth(),
                isError = isTextTooLong
            )

            Box(modifier = Modifier.fillMaxWidth()) {
                if (isTextTooLong) {
                    Text(
                        text = "Tekst jest za długi",
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.TopStart)
                    )
                }
                Text(
                    text = "${text.length}/$maxChar",
                    modifier = Modifier.align(Alignment.TopEnd)
                )
            }
        }
    }

    @Composable
    fun MyTextFieldExercise() {
        var emailText by remember { mutableStateOf("") }
        var passwordText by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            OutlinedTextField(
                value = emailText,
                onValueChange = { emailText = it },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
                label = { Text(text = "Email") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = passwordText,
                onValueChange = { passwordText = it },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
                label = { Text(text = "Password") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
    }

    @Composable
    fun MyOutlinedTextField() {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            colors = OutlinedTextFieldDefaults.colors()
        )
    }

    @Composable
    fun MyTextField() {
        var text by remember { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "label") },
            placeholder = { Text(text = "placeholder") },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
            trailingIcon = { Icon(imageVector = Icons.Default.Warning, contentDescription = "") },
            isError = true,
            colors = TextFieldDefaults.colors(),
            textStyle = TextStyle(color = Color.Red),
//            singleLine = true
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
    }

    @Composable
    fun MyShowTimeViewExercise() {
        var isSettingsShowed by remember { mutableStateOf(false) }
        var volumeValue by remember { mutableStateOf(0f) }

        Column() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isSettingsShowed,
                    onCheckedChange = { isSettingsShowed = it }
                )
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "settings icon"
                )
                Text(text = "Ustawienia")
            }

            if (isSettingsShowed) {
                Column() {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "icon volume min"
                        )
                        Slider(
                            value = volumeValue,
                            onValueChange = { volumeValue = it },
                            modifier = Modifier.width(300.dp)
                        )
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "icon volume max",
                            tint = if (volumeValue > 0.8f) Color.Red else Color.Black
                        )
                    }
                    if (volumeValue > 0.8f) {
                        Text(text = "Uważaj, bo ogłuchniesz!", color = Color.Red)
                    }
                }
            }
        }
    }
    
    @Composable
    fun MyShowTimeView() {
        var isShowed by remember { mutableStateOf(false) }
        
        Row() {
            Button(onClick = { isShowed = !isShowed }) {
                Text(text = if (isShowed) "Schowaj" else "Pokaż")
            }
            if (isShowed) {
                Text(text = "Hej, jestem tutaj! ;)")
            }
        }
    }

    @Composable
    fun MyClickModifier() {
        var isClicked by remember { mutableStateOf(false) }
        Text(
            text = if (isClicked) "Kliknąłeś mnie!" else "Jeszcze mnie nikt nie kliknął :(",
            modifier = Modifier
                .clickable { isClicked = true }
        )
    }

    @Composable
    fun MyFAB() {
        Box(modifier = Modifier.fillMaxSize()) {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add icon"
                )
            }
        }
    }

    @Composable
    fun MyIconButton() {
        var isFavorite by remember { mutableStateOf(false) }
        IconButton(onClick = { isFavorite = !isFavorite }) {
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "favorite icon",
                tint = Color.Red
            )
        }
    }
    
    @Composable
    fun MySlider() {
        var sliderValue by remember { mutableStateOf(0f) }
        Slider(
            value = sliderValue,
            onValueChange = { value -> sliderValue = value },
            modifier = Modifier.padding(horizontal = 40.dp),
            valueRange = 0f..100f,
            steps = 9,
            colors = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Green,
                activeTickColor = Color.Red
            )
        )
        Text(text = "$sliderValue")
    }

    @Composable
    fun MySwitch() {
        var isChecked by remember { mutableStateOf(false) }
        Switch(
            checked = isChecked,
            onCheckedChange = { value -> isChecked = value},
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                checkedTrackColor = Color.Yellow
            )
        )
    }

    @Composable
    fun MyRadioButton() {
        var isSelected by remember { mutableStateOf(true) }
        RadioButton(
            selected = isSelected,
            onClick = { isSelected = !isSelected },
            colors = RadioButtonDefaults.colors(selectedColor = Color.Cyan)
        )
    }

    @Composable
    fun MyCheckbox() {
        var isChecked by remember { mutableStateOf(false) }
        Checkbox(
            checked = isChecked,
            onCheckedChange = { value -> isChecked = value },
            colors = CheckboxDefaults.colors(checkedColor = Color.Green)
        )
    }
    
    @Composable
    fun MyNumberCounterButtonExercise() {
        var number by remember { mutableStateOf(0) }

        Row() {
            Button(
                onClick = { number-- },
                modifier = Modifier.size(30.dp),
                contentPadding = PaddingValues(2.dp),
                enabled = number > 0  //if (number > 0) true else false
            ) {
                Text(text = "-")
            }
            Text(
                text = "$number",
                modifier = Modifier
                    .size(height = 30.dp, width = 50.dp)
                    .padding(horizontal = 4.dp)
                    .border(1.dp, Color.Gray)
                    .wrapContentSize()
            )
            Button(
                onClick = { number++ },
                modifier = Modifier.size(30.dp),
                contentPadding = PaddingValues(2.dp)
            ) {
                Text(text = "+")
            }
        }
    }

    //var count: Int = 0

    @Composable
    fun MyClickButton() {
        var countState: MutableState<Int> = remember { mutableStateOf(0) }
        var count: Int by remember { mutableStateOf(0) }

        Column() {
            Button(onClick = { countState.value++ }) {
                Text(text = "Click countState ${countState.value}")
            }
            Button(onClick = { count++ }) {
                Text(text = "Click count $count")
            }
            MyInnerClickButton(count = count)
            MyInnerClickStateButton(countState = countState)
        }
    }
    
    @Composable
    fun MyInnerClickButton(count: Int) {
        Button(onClick = { /* count++ */ }) {
            Text(text = "Inner count $count")
        }
    }
    
    @Composable
    fun MyInnerClickStateButton(countState: MutableState<Int>) {
        Button(onClick = { countState.value++ }) {
            Text(text = "Inner count state ${countState.value}")
        }
    }

    @Composable
    fun MyUdemyLayoutExercise() {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MyUdemyInfoView(Modifier.weight(1f))
                MyUdemyPriceView()
            }
        }
    }

    @Composable
    fun MyUdemyInfoView(modifier: Modifier) {
        Column(modifier = modifier) {
            Text(
                text = "Kurs Kotlin + porównanie JAVA vs KOTLIN & quizy&zadania",
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "4,7",
                    color = Color.Yellow
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "star icon",
                    tint = Color.Yellow
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Oceny: 21",
                    color = Color.Magenta,
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "109 uczestnika kursu",
                    color = Color.White
                )
            }
        }
    }

    @Composable
    fun MyUdemyPriceView() {
        Row() {
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "49,99 zł",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = "239,99 zł",
                    color = Color.LightGray,
                    textDecoration = TextDecoration.LineThrough,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RectangleShape,
                contentPadding = PaddingValues(8.dp)
            ) {
                Text(
                    text = "Kup teraz",
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }

    @Composable
    fun MyMusicPlayerView() {
        Column() {
            Row() {
                Icon(
                    imageVector = Icons.Outlined.PlayArrow,
                    contentDescription = "play music icon",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = 8.dp)
                        .border(2.dp, Color.Black, CircleShape)
                )
                Column() {
                    Text(text = "We Are the Champions", fontWeight = FontWeight.Bold)
                    Text(text = "Queen")
                    Text(text = "News of the World", fontWeight = FontWeight.Light, color = Color.Gray)
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                LinearProgressIndicator(
                    progress = 0.7f,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Text(text = "2:16")
            }
        }
    }

    @Composable
    fun MyLayoutWeight() {
        Row() {
            Text(
                text = "Text1",
                modifier = Modifier
                    .background(Color.Green)
                    .weight(1f)
            )
            Text(
                text = "Text2",
                modifier = Modifier
                    .background(Color.Yellow)
//                    .weight(2f)
            )
            Text(
                text = "Text3",
                modifier = Modifier
                    .background(Color.Red)
//                    .weight(3f)
            )
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