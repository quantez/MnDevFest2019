package com.aandtech.navcomponent.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TimeUtils {

    companion object {
        @RequiresApi(api = Build.VERSION_CODES.O)  // O as in Oreo
        fun formattedDateTime() : String {
            val formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy      K:mm a")
            return LocalDateTime.now().format(formatter)
        }
    }

}
