package com.example.hdev.mvvm_demo.ui.projects

import android.os.Build.VERSION_CODES
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hdev.mvvm_demo.R
import com.example.hdev.mvvm_demo.data.model.Project
import com.example.hdev.mvvm_demo.databinding.ItemProjectsBinding
import java.util.Objects

class ProjectsAdapter(@NonNull private val callback: ProjectCallback) :
    RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>() {

    private var data: List<Project> = ArrayList()

    fun updateProjects(projects: List<Project>) = when {
        data.isNullOrEmpty() -> {
            this.data = projects
            notifyItemRangeInserted(0, projects.size)
        }
        else -> {
            val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun getOldListSize(): Int {
                    return data.size
                }

                override fun getNewListSize(): Int {
                    return projects.size
                }

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    return data.get(oldItemPosition).id == projects.get(newItemPosition).id
                }

                @RequiresApi(VERSION_CODES.KITKAT)
                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val project = projects.get(newItemPosition)
                    val old = projects.get(oldItemPosition)
                    return project.id == old.id && Objects.equals(project.git_url, old.git_url)
                }
            })
            this.data = projects
            result.dispatchUpdatesTo(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val binding: ItemProjectsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_projects,
            parent,
            false
        )
        binding.callback = this.callback
        return ProjectViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (data.isNullOrEmpty()) 0 else data.size
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ProjectViewHolder(private val binding: ItemProjectsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(project: Project) {
            binding.project = project
            binding.executePendingBindings()
        }
    }
}
