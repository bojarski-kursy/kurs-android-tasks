package ski.bojar.kurs.android.tasks

import android.app.Application
import android.util.Log
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import ski.bojar.kurs.android.tasks.api.ServiceConfiguration
import ski.bojar.kurs.android.tasks.api.TaskNetworkRepository
import ski.bojar.kurs.android.tasks.database.DatabaseConfiguration
import ski.bojar.kurs.android.tasks.database.TaskDatabaseRepository
import ski.bojar.kurs.android.tasks.viewmodel.TaskViewModel

class TasksApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("MyTasksApp", "Application onCreate()")

        startKoin {
            androidContext(this@TasksApplication)
            modules(
                module {
                    single { DatabaseConfiguration.getDatabase(androidContext()) }
                    factory { TaskDatabaseRepository(get()) }

                    single { ServiceConfiguration.taskService }
                    factory { TaskNetworkRepository(get()) }

                    viewModel { TaskViewModel(get(), get()) }
                }
            )
        }
    }

}