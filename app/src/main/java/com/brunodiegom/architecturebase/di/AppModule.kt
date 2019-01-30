package com.brunodiegom.architecturebase.di

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
        single { ItemRepository(get()) }
        viewModel { AddItemViewModel(get())}
        viewModel { MainActivityViewModel(get()) }
    }
}