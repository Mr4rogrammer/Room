package com.mrprogrammer.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Sample::class], version = 1)
abstract class AppDb : RoomDatabase() {


    abstract fun Query() :QueryDb

    companion object {
        @Volatile
      private  var INSTANCE: AppDb? = null

        fun getInstance(context: Context):AppDb {
            val temp = INSTANCE
            if(temp != null){
                return temp
            }

            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,AppDb::class.java,"appname").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}