package com.brunodiegom.architecturebase.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brunodiegom.architecturebase.model.Item
import com.brunodiegom.architecturebase.model.ItemDao

@Database(version = 1, entities = [Item::class])
abstract class Database : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        const val NAME = "item_db.db"
    }
}