package com.example.hdev.mvvm_demo.util

import android.content.Context
import android.widget.Toast
import androidx.annotation.NonNull

object NotificationFactory {

    fun notification(@NonNull context: Context?, msg: String) = Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}
