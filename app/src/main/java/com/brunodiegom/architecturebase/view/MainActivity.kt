package com.brunodiegom.architecturebase.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.brunodiegom.architecturebase.R
import com.brunodiegom.architecturebase.model.Item
import com.brunodiegom.architecturebase.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        item_list.layoutManager = LinearLayoutManager(this)
        item_list.setHasFixedSize(true)
        val adapter = ItemAdapter()
        item_list.adapter = adapter

        viewModel.items.observe(this, Observer<List<Item>> { items ->
            adapter.setItems(items)
        })

        fab.setOnClickListener {
            startActivity(Intent(this, AddItemActivity::class.java))
        }
    }

}
