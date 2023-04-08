package com.mrprogrammer.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy

@Dao
interface QueryDb {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(sample: Sample) :Long


   @Query("SELECT * FROM Sample")
   fun getAll():LiveData<List<Sample>>
}