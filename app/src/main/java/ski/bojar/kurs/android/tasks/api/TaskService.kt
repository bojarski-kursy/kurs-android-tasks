package ski.bojar.kurs.android.tasks.api

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ski.bojar.kurs.android.tasks.model.Task
import ski.bojar.kurs.android.tasks.model.TaskIdResponse

interface TaskService {

    @POST("tasks.json")
    suspend fun add(@Body task: Task): TaskIdResponse

    @GET("tasks.json")
    suspend fun getAll(): Map<String, Task>

    @DELETE("tasks/{id}.json")
    suspend fun deleteTask(@Path("id") taskId: String)
}