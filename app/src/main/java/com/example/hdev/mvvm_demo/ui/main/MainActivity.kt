package com.example.hdev.mvvm_demo.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.hdev.mvvm_demo.R
import com.example.hdev.mvvm_demo.data.model.User
import com.example.hdev.mvvm_demo.ui.projects.ProjectsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUsers()
    }

    private fun getUsers() {
        userViewModel.getUsers()
        userViewModel.userViewModel.observe(this, Observer<List<User>> { users ->
            Log.d("TAG", users.size.toString())
        })
    }

    private fun showProjects() {
        val projectsFragment = ProjectsFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, projectsFragment)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        userViewModel.onDestroy()
    }
}
