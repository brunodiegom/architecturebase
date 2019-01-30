package com.brunodiegom.architecturebase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.brunodiegom.architecturebase.database.ItemRepository
import com.brunodiegom.architecturebase.model.Item

class MainActivityViewModel(private val itemRepository: ItemRepository) : ViewModel() {
    val items: LiveData<List<Item>> = itemRepository.list
}