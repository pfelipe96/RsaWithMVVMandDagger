package com.example.paulo.rsawithmvvm.criptografar

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.paulo.rsawithmvvm.R
import com.example.paulo.rsawithmvvm.databinding.ActivityCriptografiaBinding

class CriptografiaActivity : AppCompatActivity() {

    lateinit var binding: ActivityCriptografiaBinding
    val criptografiaViewModel = CriptografiaViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_criptografia)
        binding.viewModel = criptografiaViewModel
        binding.executePendingBindings()
    }
}
