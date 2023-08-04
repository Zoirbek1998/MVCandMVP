package com.example.mvcandmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvcandmvp.databinding.ActivityMainBinding
import java.util.Observable
import java.util.Observer


// CONTROLLER -> vazifasini Activity yoki fragment bajaradi
class MainActivity : AppCompatActivity(), Observer {
    lateinit var binding: ActivityMainBinding
    private var model: Model? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Database da qanday ishlashi
        // appDatabase.getUserDao().adaUser(User)I
        // model -> appdatabase, dao, entity
        // controller -> activity
        // view -> recyclerView, yoki boshqa korinishlar


        // networkingda
        // model -> Apiclient, ApiService
        // Apiclient.getRetrofit().create(ApiService::java.class)
        // controller->activity
        // view -> rv, tv


        model = Model()
        model?.addObserver(this)

        // VIEW
        binding.apply {
            button1.setOnClickListener {
                //get data
                model?.setValueIndex(0)
            }
            button2.setOnClickListener {
                model?.setValueIndex(1)
            }
            button3.setOnClickListener {
                model?.setValueIndex(2)
            }
        }
    }

    override fun update(o: Observable?, arg: Any?) {
        // update presentation
        binding.button1.text = model?.getValueIndex(0).toString()
        binding.button2.text = model?.getValueIndex(1).toString()
        binding.button3.text = model?.getValueIndex(2).toString()
    }


}