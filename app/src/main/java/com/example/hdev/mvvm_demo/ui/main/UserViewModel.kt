package com.example.hdev.mvvm_demo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hdev.mvvm_demo.data.model.User
import com.example.hdev.mvvm_demo.data.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _userViewModel: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>()
    }

    private val compositeDisposable = CompositeDisposable()

    val userViewModel: LiveData<List<User>>
        get() = _userViewModel

    fun getUsers() {
        val disposable = repository.getUsers().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _userViewModel.postValue(it)
            }, {
                // Handing error
                _userViewModel.postValue(null)
            })

        compositeDisposable.add(disposable)
    }

    fun onDestroy(){
        compositeDisposable.clear()
    }
}
