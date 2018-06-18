package com.example.paulo.rsawithmvvm.mainActivity

import android.content.Intent
import android.view.View
import com.example.paulo.rsawithmvvm.R
import com.example.paulo.rsawithmvvm.criptografar.CriptografiaActivity

class MainViewHolder{
    fun onClick(view: View){
        when(view.id){
            R.id.send_encrypt ->  view.context.startActivity(Intent(view.context, CriptografiaActivity::class.java))
        }
    }
}