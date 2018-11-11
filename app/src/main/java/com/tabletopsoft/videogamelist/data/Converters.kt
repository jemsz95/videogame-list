package com.tabletopsoft.videogamelist.data

import android.arch.persistence.room.TypeConverter
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

        @TypeConverter
        @JvmStatic
        fun fromURL(url: URL) : String {
            return url.toExternalForm()
        }

        @TypeConverter
        @JvmStatic
        fun toURL(url: String) : URL {
            return URL(url)
        }
    }
}