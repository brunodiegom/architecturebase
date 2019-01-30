package com.brunodiegom.architecturebase.di

import androidx.room.Room
import com.brunodiegom.architecturebase.database.Database
import com.brunodiegom.architecturebase.database.ItemRepository
import com.brunodiegom.architecturebase.viewmodel.AddItemViewModel
import com.brunodiegom.architecturebase.viewmodel.MainActivityViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * Injection app module.
 */
object AppModule {
    val appModule = module {

        single {
            Room.databaseBuilder(get(), Database::class.java, Database.NAME).build()
        }

        single { get<Database>().itemDao() }

        single { ItemRepository(get()) }

        viewModel { AddItemViewModel(get())}

        viewModel { MainActivityViewModel(get()) }
    }
}