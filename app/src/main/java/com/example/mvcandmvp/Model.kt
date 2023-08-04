package com.example.mvcandmvp

import java.util.Observable


//MODEL
class Model : Observable() {
    val list: MutableList<Int>

    init {
        list = ArrayList(3)
        list.add(0)
        list.add(0)
        list.add(0)
    }

    fun getValueIndex(index: Int): Int {
        return list[index]
    }

    fun setValueIndex(index: Int) {
        list[index] +=1

//        update data
        setChanged()
        notifyObservers()
    }
}