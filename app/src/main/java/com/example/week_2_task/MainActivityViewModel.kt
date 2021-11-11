package com.example.week_2_task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Viewmodel class that holds the counter variable which updates
 * the UI when a configuration change occurs
 */

class MainActivityViewModel : ViewModel() {

    private var _counter = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() = _counter
    init {
        _counter.value = 0
    }


    fun changeCounterScore(){
        _counter.value = _counter.value?.plus(1)
    }
}