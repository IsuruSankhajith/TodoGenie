package com.example.demotodolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    // ViewHolder class for holding the item views
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTodoTitle: TextView = itemView.findViewById(R.id.tvTodoTitle) // TextView for todo title
        val cbDone: CheckBox = itemView.findViewById(R.id.cbDone) // CheckBox for marking todo as done
    }

    // Create new view holders (item views)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteDoneTodos() {
        // Keep track of the number of items removed
        val initialSize = todos.size
        todos.removeAll { todo -> todo.isChecked }
        val removedCount = initialSize - todos.size
        // Notify only about the removed items
        if (removedCount > 0) {
            notifyItemRangeRemoved(initialSize - removedCount, removedCount)
        }
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if (isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    // Bind data to the views
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todos[position]

        holder.tvTodoTitle.text = curTodo.title
        holder.cbDone.isChecked = curTodo.isChecked

        // Toggle strikethrough based on the todo's checked status
        toggleStrikeThrough(holder.tvTodoTitle, curTodo.isChecked)

        // Clear previous listener to prevent incorrect state changes
        holder.cbDone.setOnCheckedChangeListener(null)

        // Handle the checkbox toggle event
        holder.cbDone.setOnCheckedChangeListener { _, isChecked ->
            toggleStrikeThrough(holder.tvTodoTitle, isChecked)
            curTodo.isChecked = isChecked // Update the checked status
        }
    }

    // Return the total number of items
    override fun getItemCount(): Int {
        return todos.size
    }
}
