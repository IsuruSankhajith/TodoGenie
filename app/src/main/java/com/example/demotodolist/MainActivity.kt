package com.example.demotodolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter
    private lateinit var btnAddTodo: Button
    private lateinit var btnDeleteDoneTodos: Button
    private lateinit var etTodoTitle: EditText // Ensure this matches the EditText ID

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply system window insets to adjust for edge-to-edge design
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        btnAddTodo = findViewById(R.id.btnAddTodo)
        btnDeleteDoneTodos = findViewById(R.id.btnDeleteDoneTodos)
        etTodoTitle = findViewById(R.id.etTodoTitle)

        // Setup RecyclerView and adapter
        todoAdapter = TodoAdapter(mutableListOf())
        val rvTodoItems = findViewById<RecyclerView>(R.id.rvTodoItems)
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        // Add new Todo when button is clicked
        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                // Launch a coroutine to add the todo
                coroutineScope.launch {
                    val todo = Todo(todoTitle)
                    todoAdapter.addTodo(todo)
                    etTodoTitle.text.clear() // Clear the text field after adding a new todo
                }
            }
        }

        // Delete done Todos when button is clicked
        btnDeleteDoneTodos.setOnClickListener {
            // Launch a coroutine to delete done todos
            coroutineScope.launch {
                todoAdapter.deleteDoneTodos() // Call the adapter method to delete checked todos
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancel the coroutine scope to prevent memory leaks
        coroutineScope.cancel()
    }
}
