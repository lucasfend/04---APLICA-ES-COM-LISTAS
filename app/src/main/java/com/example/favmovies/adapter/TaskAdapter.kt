package com.example.favmovies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.favmovies.R
import com.example.favmovies.model.Task

class TaskAdapter(private val taskList: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTaskTitle: TextView = itemView.findViewById(R.id.tvTaskTitle)
        val tvTaskDesc: TextView = itemView.findViewById(R.id.tvTaskDesc)
        val btnComplete: Button = itemView.findViewById(R.id.btnComplete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.tvTaskTitle.text = task.title
        holder.tvTaskDesc.text = task.description

        if (task.isCompleted) {
            holder.btnComplete.isEnabled = false
            holder.btnComplete.text = "Completed"
        } else {
            holder.btnComplete.isEnabled = true
            holder.btnComplete.text = "Done"
        }

        holder.btnComplete.setOnClickListener {
            task.isCompleted = true
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}