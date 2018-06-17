package com.example.paulo.rsawithmvvm.criptografar

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.paulo.rsawithmvvm.BR
import com.example.paulo.rsawithmvvm.R

class CriptografiaActivity : AppCompatActivity(), CriptografiaActivityInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val criptografiaViewModel = CriptografiaViewModel(this)
        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_criptografia)
        binding.setVariable(BR.viewModel, criptografiaViewModel)
    }
}
