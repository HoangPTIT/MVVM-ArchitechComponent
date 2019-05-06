package com.example.hdev.mvvm_demo.ui.projects

import com.example.hdev.mvvm_demo.data.model.Project

interface ProjectCallback {
    fun onClick(project: Project)
}
