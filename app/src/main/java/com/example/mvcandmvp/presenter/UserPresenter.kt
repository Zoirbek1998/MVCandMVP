package com.example.mvcandmvp.presenter

import android.content.Context
import androidx.room.util.query
import com.example.mvcandmvp.db.AppDatabase
import com.example.mvcandmvp.db.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//PRESENTER
class UserPresenter(private val context: Context, private val contractView: CantractView) {

    private val addDatabase = AppDatabase.getInstance(context)
    private val userDao = addDatabase.userDao()

    fun setUsers() {
        contractView.showProgressBar()
        contractView.showUsers(userDao.getUsers())
        contractView.hideProgressBar()
//        GlobalScope.launch(Dispatchers.Main) {
//            delay(1000)
//
//        }

    }

    fun addUser(name: String, age: String) {
        val userEntity = UserEntity(name = name, age = age)
        userDao.addUser(userEntity)
        setUsers()
    }

}