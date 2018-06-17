package com.example.paulo.rsawithmvvm.criptografar

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.paulo.rsawithmvvm.R
import com.example.paulo.rsawithmvvm.databinding.ActivityCriptografiaBinding

class CriptografiaActivity : AppCompatActivity(), CriptografiaActivityInterface {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val criptografiaViewModel = CriptografiaViewModel(this)
        val binding = DataBindingUtil.setContentView<ActivityCriptografiaBinding>(this, R.layout.activity_criptografia)
        binding.viewModel = criptografiaViewModel
        binding.executePendingBindings()
    }
}
