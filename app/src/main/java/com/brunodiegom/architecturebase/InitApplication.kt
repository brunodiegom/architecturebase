package com.brunodiegom.architecturebase

import android.app.Application
import com.brunodiegom.architecturebase.database.Database
import com.brunodiegom.architecturebase.di.AppModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.android.startKoin

class InitApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(AppModule.appModule))

        //Stetho
        Stetho.initializeWithDefaults(this)
    }
}