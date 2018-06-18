package com.example.paulo.rsawithmvvm.descriptografar

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.paulo.rsawithmvvm.R
import com.example.paulo.rsawithmvvm.databinding.ActivityDescriptografiaActivtyBinding

class DescriptografiaActivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityDescriptografiaActivtyBinding>(this,R.layout.activity_descriptografia_activty)
        binding.viewModel = DescriptografiaViewModel()
        binding.executePendingBindings()
    }
}
