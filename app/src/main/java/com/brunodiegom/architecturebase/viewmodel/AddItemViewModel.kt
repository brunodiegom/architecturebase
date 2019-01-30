package com.brunodiegom.architecturebase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.brunodiegom.architecturebase.database.ItemRepository
import com.brunodiegom.architecturebase.model.Item

class AddItemViewModel(private val itemRepository: ItemRepository) : ViewModel() {

    val data = MutableLiveData<Item>()

    init {
        data.value = Item()
    }

    fun setValue(item: Item) {
        data.value = item
    }

    fun save() {
        data.value?.let { itemRepository.insert(it) }
    }
}
