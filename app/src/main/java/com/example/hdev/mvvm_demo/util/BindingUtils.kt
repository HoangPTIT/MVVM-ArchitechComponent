package com.example.hdev.mvvm_demo.util

import android.view.View
import androidx.databinding.BindingAdapter

object BindingUtils {
    @JvmStatic
    @BindingAdapter("visibleGone")
    fun visibleGone(view: View, isLoading: Boolean) {
        when {
            !isLoading -> view.visibility = View.VISIBLE
            else -> view.visibility = View.GONE
        }
    }
}
