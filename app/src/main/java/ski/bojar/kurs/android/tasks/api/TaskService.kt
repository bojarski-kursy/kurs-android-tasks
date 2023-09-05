package ski.bojar.kurs.android.tasks.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ski.bojar.kurs.android.tasks.model.Task

interface TaskService {

    @POST("tasks.json")
    suspend fun add(@Body task: Task)

    @GET("tasks.json")
    suspend fun getAll(): Map<String, Task>
}