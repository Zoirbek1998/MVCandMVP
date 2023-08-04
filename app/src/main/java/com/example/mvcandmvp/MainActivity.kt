package com.example.mvcandmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.mvcandmvp.adapter.UserAdapter
import com.example.mvcandmvp.databinding.ActivityMainBinding
import com.example.mvcandmvp.db.AppDatabase
import com.example.mvcandmvp.db.UserEntity
import com.example.mvcandmvp.presenter.CantractView
import com.example.mvcandmvp.presenter.UserPresenter


// CONTROLLER -> vazifasini Activity yoki fragment bajaradi
class MainActivity : AppCompatActivity(),CantractView {
    lateinit var binding: ActivityMainBinding
    lateinit var userPresenter: UserPresenter
    lateinit var userAdapter : UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        userAdapter = UserAdapter()
        binding.rv.adapter = userAdapter

        userPresenter = UserPresenter(this,this)
        userPresenter.setUsers()


        binding.saveBtn.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val age = binding.ageEt.text.toString()
            userPresenter.addUser(name,age)
        }
    }

    override fun showProgressBar() {
        binding.progressBar.isVisible = true
        binding.rv.isVisible = false
    }

    override fun hideProgressBar() {
        binding.progressBar.isVisible = false
        binding.rv.isVisible = true
    }

    override fun showUsers(userList: List<UserEntity>) {
        userAdapter.submitList(userList)
    }


}