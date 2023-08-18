package ski.bojar.kurs.android.tasks.model

import androidx.compose.ui.graphics.Color
import java.io.Serializable
import java.util.UUID

data class Task(
    val title: String,
    val description: String,
    val color: ColorType,
    val id: String = UUID.randomUUID().toString()
) : Serializable

enum class ColorType(val color: Color) {
    GREEN(Color.Cyan),
    YELLOW(Color.Yellow),
    RED(Color.Magenta)
}
