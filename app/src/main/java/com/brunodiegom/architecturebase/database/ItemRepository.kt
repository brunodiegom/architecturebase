package com.brunodiegom.architecturebase.database

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.brunodiegom.architecturebase.model.Item
import com.brunodiegom.architecturebase.model.ItemDao

class ItemRepository(private val itemDao: ItemDao) {

    val list: LiveData<List<Item>> = itemDao.getAll()

    fun insert(item: Item) {
        InsertAsyncTask(itemDao).execute(item)
    }

    fun update(item: Item) {
        UpdateAsyncTask(itemDao).execute(item)
    }

    fun delete(item: Item) {
        DeleteAsyncTask(itemDao).execute(item)
    }

    private class InsertAsyncTask internal constructor(private val dao: ItemDao) :
        AsyncTask<Item, Void, Void>() {
        override fun doInBackground(vararg params: Item): Void? {
            dao.insert(params[0])
            return null
        }
    }

    private class UpdateAsyncTask internal constructor(private val dao: ItemDao) :
        AsyncTask<Item, Void, Void>() {
        override fun doInBackground(vararg params: Item): Void? {
            dao.update(params[0])
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: ItemDao) :
        AsyncTask<Item, Void, Void>() {
        override fun doInBackground(vararg params: Item): Void? {
            dao.delete(params[0])
            return null
        }
    }
}