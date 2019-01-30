package com.brunodiegom.architecturebase.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ItemDao {
    @Query("SELECT * FROM item") fun getAll(): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insert(vararg item: Item)

    @Update
    fun update(item: Item)

    @Delete
    fun delete(item: Item)
}