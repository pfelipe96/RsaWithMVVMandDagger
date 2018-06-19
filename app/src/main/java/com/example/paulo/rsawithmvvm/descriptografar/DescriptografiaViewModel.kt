package com.example.paulo.rsawithmvvm.descriptografar

import android.databinding.ObservableField
import android.text.Editable
import android.text.TextWatcher

class DescriptografiaViewModel{

    val keyPublic = ObservableField<String>()
    val functionTotiente = ObservableField<String>()

    private var firstNumberPrime = 0
    private var secondNumberPrime = 0

    val watcherKeyPublic: TextWatcher = object: TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            s?.let {
                keyPublic.set(it.toString())
            }

            lookForKeyPrivate()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }

    val watcherFunctionTotiente: TextWatcher = object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            s?.let {
                functionTotiente.set(it.toString())
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    }


    private fun lookForKeyPrivate(){
        var functionTotienteToInt = functionTotiente.get().toString().toInt()

        for (i in 1..functionTotienteToInt){
            if(functionTotienteToInt % i == 0){
                var x = functionTotienteToInt / i
                if((x+1) % 2 != 0 && (i+1) % 2 != 0) {

                }
            }
        }
    }
}