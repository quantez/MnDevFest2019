package com.aandtech.navcomponent.ViewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.aandtech.navcomponent.utils.TimeUtils.Companion.formattedDateTime
import kotlinx.coroutines.*

@RequiresApi(Build.VERSION_CODES.O)
class HomeViewModel : ViewModel() {

    private val timeDateLiveData = MutableLiveData<String>()
    private val viewModelJob = Job()

    val timeDate: LiveData<String>
        get() = timeDateLiveData

    init {
        val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

        uiScope.launch {
            while(true) {
                timeDateLiveData.value = formattedDateTime()
                delay(5_000)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}