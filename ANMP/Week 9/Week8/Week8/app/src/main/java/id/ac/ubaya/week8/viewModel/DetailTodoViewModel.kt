package id.ac.ubaya.week8.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import id.ac.ubaya.week8.model.Todo
import id.ac.ubaya.week8.model.TodoDatabase
import id.ac.ubaya.week8.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailTodoViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private val job = Job()
    val todoLD = MutableLiveData<Todo>()

    fun addTodo(todoList: List<Todo>) {
        launch {
            val db = buildDb(getApplication())
            db.todoDao().insertAll(*todoList.toTypedArray())
        }
    }
    override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Main

    fun fetch(uuid: Int) {
        launch {
            val db = buildDb(getApplication())
            todoLD.value = db.todoDao().selectTodo(uuid)
        }
    }

    fun update(id: Int, title: String, notes: String, priority: Int) {
        launch {
            val db = buildDb(getApplication())
            db.todoDao().update(id, title, notes, priority)
        }
    }
}
