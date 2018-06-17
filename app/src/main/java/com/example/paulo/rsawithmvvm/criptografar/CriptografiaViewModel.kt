package com.example.paulo.rsawithmvvm.criptografar

import android.annotation.SuppressLint
import android.databinding.ObservableField
import android.text.Editable
import android.text.TextWatcher
import java.math.BigDecimal

class CriptografiaViewModel(criptografiaActivity: CriptografiaActivity): CriptografiaViewHolderInterface {

    val keyPublic = ObservableField<String>()
    val firstPrime = ObservableField<String>()
    val secondPrime = ObservableField<String>()
    val textForEncryption = ObservableField<String>()
    val textAlreadyEncryptionn = ObservableField<String>()

    val watcherKeyPublic: TextWatcher = object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            keyPublic.set(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }
    val watcherFirstPrime: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            firstPrime.set(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }
    val watcherSecondPrime: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            secondPrime.set(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }
    val watcherTextForEncryption: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            s?.let{
                createEncryption(it.toString())
                textForEncryption.set(s.toString())
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }

    @SuppressLint("UseValueOf")
    fun createEncryption(valueObject : String){
        var arrayListToChar = ArrayList<String>()
        var keyPublic = keyPublic.get().toString().toInt()
        var multiplyTwoPrime = BigDecimal(firstPrime.get()!!.toInt()*secondPrime.get()!!.toInt())

        valueObject.forEach {
            var convertCharToAscii = it.toInt()
            var calculatePow = BigDecimal(convertCharToAscii).pow(keyPublic)
            var calculateMod = Integer(calculatePow.remainder(multiplyTwoPrime).intValueExact())
            arrayListToChar.add(calculateMod.toString())
        }

        textAlreadyEncryptionn.set(arrayListToChar.toString()
                .replace("[","")
                .replace(",", "")
                .replace("]",""))

        textAlreadyEncryptionn.notifyChange()
    }
}


