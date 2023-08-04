package com.example.mvcandmvp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    fun addUser(userEntity: UserEntity)

    @Query("select * from userentity")
    fun getUsers(): List<UserEntity>
}