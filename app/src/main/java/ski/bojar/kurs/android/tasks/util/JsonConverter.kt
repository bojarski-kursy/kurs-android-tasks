package ski.bojar.kurs.android.tasks.util

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import ski.bojar.kurs.android.tasks.model.Task

object JsonConverter {
    private val moshi = Moshi.Builder().build()

    fun taskListToJson(taskList: List<Task>): String {
        val type = Types.newParameterizedType(List::class.java, Task::class.java)
        return moshi.adapter<List<Task>>(type).toJson(taskList)
    }

    fun taskListFromJson(json: String): List<Task> {
        val type = Types.newParameterizedType(List::class.java, Task::class.java)
        return moshi.adapter<List<Task>>(type).fromJson(json) ?: emptyList()
    }
}