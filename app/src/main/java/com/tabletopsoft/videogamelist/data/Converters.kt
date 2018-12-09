package com.tabletopsoft.videogamelist.data

import androidx.room.TypeConverter
import java.net.URL
import java.util.Date

class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromDate(date: Date) : Long {
            return date.time
        }

        @TypeConverter
        @JvmStatic
        fun toDate(date: Long) : Date {
            return Date(date)
        }
    }
}