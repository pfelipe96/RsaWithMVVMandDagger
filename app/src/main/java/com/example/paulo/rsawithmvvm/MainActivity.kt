package com.example.paulo.rsawithmvvm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.paulo.rsawithmvvm.criptografar.CriptografiaActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, CriptografiaActivity::class.java))
    }
}
