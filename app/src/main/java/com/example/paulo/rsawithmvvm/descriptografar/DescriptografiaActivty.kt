package com.example.paulo.rsawithmvvm.descriptografar

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.paulo.rsawithmvvm.R
import com.example.paulo.rsawithmvvm.databinding.ActivityDescriptografiaActivtyBinding
import kotlinx.android.synthetic.main.toolbar.*

class DescriptografiaActivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar_id)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val binding = DataBindingUtil.setContentView<ActivityDescriptografiaActivtyBinding>(this, R.layout.activity_descriptografia_activty)
        binding.viewModel = DescriptografiaViewModel()
        binding.executePendingBindings()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> onBackPressed()
        }
        return true
    }
}
