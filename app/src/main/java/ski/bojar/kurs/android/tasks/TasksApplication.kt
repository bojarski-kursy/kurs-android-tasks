package ski.bojar.kurs.android.tasks

import android.app.Application
import android.util.Log

class TasksApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("MyTasksApp", "Application onCreate()")
    }

}