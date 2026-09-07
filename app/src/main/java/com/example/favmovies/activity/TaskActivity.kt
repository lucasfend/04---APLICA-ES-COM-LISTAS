package com.example.favmovies

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.favmovies.adapter.TaskAdapter
import com.example.favmovies.model.Task

class TaskActivity : AppCompatActivity() {

    private val taskList = mutableListOf<Task>()
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val etTaskTitle = findViewById<EditText>(R.id.etTaskTitle)
        val etTaskDesc = findViewById<EditText>(R.id.etTaskDesc)
        val btnAddTask = findViewById<Button>(R.id.btnAddTask)
        val rvTasks = findViewById<RecyclerView>(R.id.rvTasks)

        adapter = TaskAdapter(taskList)
        rvTasks.adapter = adapter
        rvTasks.layoutManager = LinearLayoutManager(this)

        btnAddTask.setOnClickListener {
            val title = etTaskTitle.text.toString().trim()
            val desc = etTaskDesc.text.toString().trim()

            if (title.isNotEmpty() && desc.isNotEmpty()) {
                val newTask = Task(title, desc)
                taskList.add(newTask)
                adapter.notifyItemInserted(taskList.size - 1)

                etTaskTitle.text.clear()
                etTaskDesc.text.clear()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}