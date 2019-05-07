package com.example.hdev.mvvm_demo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hdev.mvvm_demo.data.model.User
import com.example.hdev.mvvm_demo.data.repository.UserRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _userViewModel: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>()
    }

    private val compositeDisposable = CompositeDisposable()

    val userViewModel: LiveData<List<User>>
        get() = _userViewModel

    class UserDataWrap(val users: List<User>, val clazz: List<User>, val town: List<User>)

    fun getUsers() {
        val usersSingle = repository.getUsers().onErrorReturn { ArrayList() }
        val clazzSingle = repository.getUsers().onErrorReturn { ArrayList() }
        val hometownSingle = repository.getUsers().onErrorReturn { ArrayList() }
        val disposable1 =
            Single.zip<List<User>, List<User>, List<User>, UserDataWrap>(usersSingle, clazzSingle, hometownSingle,
                Function3 { users1, users2, users3 ->
                    return@Function3 UserDataWrap(users1, users2, users3)
                })
                .subscribe({ userData ->
                    userData.users
                    userData.clazz
                    userData.town
                }, { throwable ->
                })

        val disposable = repository.getUsers().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _userViewModel.postValue(it)
            }, {
                // Handing error
                _userViewModel.postValue(null)
            })

        compositeDisposable.add(disposable)
        compositeDisposable.add(disposable1)
    }

    fun onDestroy() {
        compositeDisposable.dispose()
    }
}
