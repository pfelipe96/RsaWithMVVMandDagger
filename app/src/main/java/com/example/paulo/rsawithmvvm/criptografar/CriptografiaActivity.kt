package com.example.paulo.rsawithmvvm.criptografar

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.paulo.rsawithmvvm.R
import com.example.paulo.rsawithmvvm.databinding.ActivityCriptografiaBinding
import kotlinx.android.synthetic.main.toolbar.*

class CriptografiaActivity : AppCompatActivity(), CriptografiaActivityInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar_id)
        supportActionBar?.title = getString(R.string.action_bar_title_encryption)


        val binding = DataBindingUtil.setContentView<ActivityCriptografiaBinding>(this, R.layout.activity_criptografia)
        binding.viewModel = CriptografiaViewModel(this)
        binding.executePendingBindings()
    }
}
