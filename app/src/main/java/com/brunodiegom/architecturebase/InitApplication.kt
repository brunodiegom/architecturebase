package com.brunodiegom.architecturebase

import android.app.Application
import androidx.room.Room
import com.brunodiegom.architecturebase.database.DataBase
import com.brunodiegom.architecturebase.di.AppModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.android.startKoin

class InitApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(AppModule.appModule))

        //Room
        database = Room.databaseBuilder(this, DataBase::class.java, DATABASE_NAME).allowMainThreadQueries().build()

        //Stetho
        Stetho.initializeWithDefaults(this)
    }

    companion object {
        const val DATABASE_NAME = "item_db"
        lateinit var database: DataBase
    }
}