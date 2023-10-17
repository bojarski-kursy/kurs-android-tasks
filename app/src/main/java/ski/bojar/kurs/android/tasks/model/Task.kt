package ski.bojar.kurs.android.tasks.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import ski.bojar.kurs.android.tasks.ui.theme.CardGreen
import ski.bojar.kurs.android.tasks.ui.theme.CardRed
import ski.bojar.kurs.android.tasks.ui.theme.CardYellow
import java.io.Serializable
import java.util.UUID

@Entity
@JsonClass(generateAdapter = true)
data class Task(
    val title: String,
    val description: String,
    val colorType: ColorType,
    @PrimaryKey val id: String = UUID.randomUUID().toString()
) : Serializable

enum class ColorType(val color: Color) {
    GREEN(CardGreen),
    YELLOW(CardYellow),
    RED(CardRed)
}
