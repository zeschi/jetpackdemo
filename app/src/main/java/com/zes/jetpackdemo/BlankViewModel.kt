package com.zes.jetpackdemo

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class BlankViewModel : ViewModel() {

    private val currentName by lazy {
        MutableLiveData<String>().also {
            loadData()
        }
    }

    fun getCurrentName(): LiveData<Int> = currentName.switchMap {
        liveData {
            emit(getSymbol(it))
        }
    }

    private suspend fun getSymbol(id: String): Int {
        delay(1000L)
        if (id == "AAPL0") {
            return 0
        }
        return 100
    }

    fun loadData() {

        viewModelScope.launch {
            try {
                var i = 0
                while (isActive) {
                    delay(2000L)
                    currentName.value = "AAPL$i"
                    i++
                }
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }

    }
}