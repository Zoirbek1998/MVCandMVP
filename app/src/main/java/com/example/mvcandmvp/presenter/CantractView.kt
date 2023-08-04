package com.example.mvcandmvp.presenter

import com.example.mvcandmvp.db.UserEntity

interface CantractView {

    fun showProgressBar()

    fun hideProgressBar()

    fun showUsers(userList: List<UserEntity>)
}