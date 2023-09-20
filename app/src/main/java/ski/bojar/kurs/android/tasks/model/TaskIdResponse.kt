package ski.bojar.kurs.android.tasks.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TaskIdResponse(val name: String)
