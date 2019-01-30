package com.brunodiegom.architecturebase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true) var uid: Long? = null,
    @ColumnInfo(name = "name") var name: String? = "",
    @ColumnInfo(name = "birthday") var birthday: String? = ""
)