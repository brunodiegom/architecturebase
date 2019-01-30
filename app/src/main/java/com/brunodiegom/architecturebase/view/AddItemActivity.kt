package com.brunodiegom.architecturebase.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.brunodiegom.architecturebase.R
import com.brunodiegom.architecturebase.databinding.ActivityAddItemBinding
import com.brunodiegom.architecturebase.viewmodel.AddItemViewModel
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.android.viewmodel.ext.android.viewModel

class AddItemActivity : AppCompatActivity() {

    private val viewModel: AddItemViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViewModel()
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                viewModel.save()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun bindViewModel() {
        val binding: ActivityAddItemBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_item)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }
}