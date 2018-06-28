package com.example.paulo.rsawithmvvm.descriptografar

import android.annotation.SuppressLint
import android.databinding.BindingAdapter
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import java.math.BigDecimal
import java.util.*
import kotlin.collections.ArrayList
import android.animation.Animator
import android.animation.AnimatorListenerAdapter

class DescriptografiaViewModel {

    val keyPublic = ObservableField<String>()
    val functionTotiente = ObservableField<String>()

    val textFirstNumberPrime = ObservableField<String>()
    val textSecondNumberPrime = ObservableField<String>()
    val textKeyPrivate = ObservableField<String>()
    val textDecrypted = ObservableField<String>()
    val textEncrypted = ObservableField<String>()

    val linearLayoutKeyPublic = ObservableBoolean(false)
    val linearLayoutEncrypted = ObservableBoolean(false)

    private lateinit var timerFt: Timer
    private lateinit var timerKy: Timer
    private val listTextDecrypted = ArrayList<ConstructorList>()


    val watcherKeyPublic: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            s?.let {
                keyPublic.set(it.toString())
            }

            timerKy = Timer()
            timerKy.schedule(object : TimerTask() {
                override fun run() {
                    s.let {
                        lookForKeyOtherPrivate()
                    }
                }
            }, 600)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            try {
                timerKy.let { timerKy.cancel() }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }

    val watcherFunctionTotiente: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            s?.let {
                functionTotiente.set(it.toString())
            }

            timerFt = Timer()
            timerFt.schedule(object : TimerTask() {
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
                timerFt.let { timerFt.cancel() }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }

    val watcherTextEncrypted: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            s?.let {
                textEncrypted.set(it.toString())
                decryptText()
            }
        }


        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

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

    private fun lookForKeyOtherPrivate() {
        if (!functionTotiente.get().toString().isNullOrEmpty()) {
            val functionTotienteToInt = functionTotiente.get().toString().toInt()
            val keyPublicToInt = keyPublic.get().toString().toInt()
            for (i in 0..functionTotienteToInt) {
                if ((keyPublicToInt * i) % functionTotienteToInt == 1) {
                    textKeyPrivate.set(i.toString())
                    linearLayoutEncrypted.set(true)
                }
            }
        }
    }

    @SuppressLint("UseValueOf")
    private fun decryptText() {
        if (!textEncrypted.get().toString().isNullOrEmpty()) {

            val textEncryptedSlipt = textEncrypted.get().toString().split(" ")
            val multiplyNumberPrime = BigDecimal(textFirstNumberPrime.get().toString().toInt() * textSecondNumberPrime.get().toString().toInt())
            val inverseKeyPublicToInt = textKeyPrivate.get().toString().toInt()

            textEncryptedSlipt.forEachIndexed { index, it ->

                if (it.isNotEmpty())
                    if (it.length >= 2)
                        if(listTextDecrypted.size == index)
                            calculateDecrypted(inverseKeyPublicToInt, multiplyNumberPrime, index, it)
                        else if(listTextDecrypted.size ==  textEncryptedSlipt.size){
                            listTextDecrypted.removeAt((listTextDecrypted.size -1))
                        }

            }

            var mergeChar = ""

            listTextDecrypted.forEach {
                mergeChar += it.worddDecrypted.toString()
            }

            textDecrypted.set(mergeChar)
        }
    }

    private fun calculateDecrypted(inverseKeyPublicToInt: Int, multiplyNumberPrime: BigDecimal, index: Int, it: String) {
        val calculatePow = BigDecimal(it.toInt()).pow(inverseKeyPublicToInt)
        val calculateMod = calculatePow.remainder(multiplyNumberPrime).intValueExact()

        if (calculateMod <= 127) {
            val convertIntToChar = calculateMod.toChar()
            listTextDecrypted.add(index, ConstructorList(convertIntToChar, it))
        }
    }


    class ConstructorList(var worddDecrypted: Char, var wordCrypted: String)


    companion object {
        @JvmStatic
        @BindingAdapter("android:visibility")
        fun setVisibility(view: View, value: Boolean) {
            if (value) {
                view.apply {
                    animate().alpha(1f).setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            this@apply.alpha = 1f
                            visibility = View.VISIBLE
                        }
                    })
                }
            } else
                view.apply {
                    animate().alpha(0f).setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            this@apply.alpha = 1f
                            this@apply.visibility = View.GONE
                        }
                    })
                }
        }
    }

}