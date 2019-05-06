package com.example.hdev.mvvm_demo.ui.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hdev.mvvm_demo.R
import com.example.hdev.mvvm_demo.data.model.Project
import com.example.hdev.mvvm_demo.databinding.FragmentProjectsBinding
import com.example.hdev.mvvm_demo.util.NotificationFactory

class ProjectsFragment : Fragment(), ProjectCallback {

    private lateinit var binding: FragmentProjectsBinding

    private val adapter by lazy { ProjectsAdapter(this) }

    private val viewModel by lazy {
        activity?.let {
            ViewModelProviders.of(it).get(ProjectsViewModel::class.java)
        } ?: throw Exception("")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_projects, container, false)
        binding.lifecycleOwner = this
        binding.projectList.adapter = adapter
        binding.isLoading = true
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectsViewModel) {
        // Update the list when the data changes
    }

    override fun onClick(project: Project) {
        NotificationFactory.notification(context, "Alo")
    }
}
