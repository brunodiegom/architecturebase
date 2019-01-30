package com.brunodiegom.architecturebase.viewmodel

import androidx.lifecycle.ViewModel
import com.brunodiegom.architecturebase.database.ItemRepository
import com.brunodiegom.architecturebase.model.Item

class AddItemViewModel(private val itemRepository: ItemRepository) : ViewModel() {

    fun save(item: Item) {
        itemRepository.insert(item)
    }
}
