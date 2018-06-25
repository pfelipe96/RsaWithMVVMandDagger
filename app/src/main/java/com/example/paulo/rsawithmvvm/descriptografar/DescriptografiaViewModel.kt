package com.example.paulo.rsawithmvvm.descriptografar

import android.databinding.BindingAdapter
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import java.util.*

class DescriptografiaViewModel{

    val keyPublic = ObservableField<String>()
    val functionTotiente = ObservableField<String>()
    val textFirstNumberPrime = ObservableField<String>()
    val textSecondNumberPrime = ObservableField<String>()
    val linearLayoutKeyPublic = ObservableBoolean(false)
    private lateinit var timer: Timer

    val watcherKeyPublic: TextWatcher = object: TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            s?.let {
                keyPublic.set(it.toString())
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }

    val watcherFunctionTotiente: TextWatcher = object: TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            s?.let {
                functionTotiente.set(it.toString())
            }

            timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    s.let {
                        lookForKeyPrivate()
                    }
                }
            }, 600)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            try {
                timer.let { timer.cancel() }
            }catch (exception: Exception){
                exception.printStackTrace()
            }
        }
    }


    private fun lookForKeyPrivate() {
        if (!functionTotiente.get().toString().isNullOrEmpty()) {
            val functionTotienteToInt = functionTotiente.get().toString().toInt()

            var firstNumberPrimeLocal = 0
            var secondNumberPrimeLocal = 0

            for (i in 1..functionTotienteToInt) {
                if (functionTotienteToInt % i == 0) {
                    var y = i + 1
                    var x = (functionTotienteToInt / i) + 1
                    if (x % 2 != 0 && y % 2 != 0) {
                        for (z in 2..9) {
                            if (x % z != 0) {
                                if (firstNumberPrimeLocal != -1) {
                                    firstNumberPrimeLocal = x
                                }
                            } else {
                                firstNumberPrimeLocal = -1
                            }

                            if (y % z != 0) {
                                if (secondNumberPrimeLocal != -1) {
                                    secondNumberPrimeLocal = y
                                }
                            } else {
                                secondNumberPrimeLocal = -1
                            }
                        }
                        if (firstNumberPrimeLocal != -1 && secondNumberPrimeLocal != -1) {
                            textFirstNumberPrime.set(firstNumberPrimeLocal.toString())
                            textSecondNumberPrime.set(secondNumberPrimeLocal.toString())
                            linearLayoutKeyPublic.set(true)
                        }

                        firstNumberPrimeLocal = 0
                        secondNumberPrimeLocal = 0
                    }
                }
            }
        }
    }


    companion object {
        @JvmStatic
        @BindingAdapter("android:visibility")
        fun setVisibility(view: View, value: Boolean) {
            if(value)
                view.visibility = View.VISIBLE
            else
                view.visibility = View.GONE
        }
    }


    fun getSaleVisibility(): Int {
        return  if(textFirstNumberPrime.get().toString().isNullOrEmpty() && textSecondNumberPrime.toString().isNullOrEmpty())
            View.GONE
        else
            View.VISIBLE
    }

}