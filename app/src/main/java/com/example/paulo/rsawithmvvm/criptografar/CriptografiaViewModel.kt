package com.example.paulo.rsawithmvvm.criptografar

import android.databinding.ObservableField
import android.os.Build
import android.support.annotation.RequiresApi
import android.text.Editable
import android.text.TextWatcher
import java.util.*

class CriptografiaViewModel: CriptografiaViewHolderInterface{

    val primeKeyPublic = ObservableField<String>()
    val primeFirstPrime = ObservableField<String>()
    val primeSecondPrime = ObservableField<String>()


    var watcherPrimeKeyPublic: TextWatcher = object : TextWatcher {
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        override fun afterTextChanged(s: Editable) {
            if (!Objects.equals(primeKeyPublic.get(), s.toString())) {
                primeKeyPublic.set(s.toString())
            }
        }
    }

    var watcherPrimeFirstPrime: TextWatcher = object : TextWatcher {
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        override fun afterTextChanged(s: Editable) {
            if (!Objects.equals(primeKeyPublic.get(), s.toString())) {
                primeKeyPublic.set(s.toString())
            }
        }
    }

    var watcherPrimeSecondPrime: TextWatcher = object : TextWatcher {
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        override fun afterTextChanged(s: Editable) {
            if (!Objects.equals(primeKeyPublic.get(), s.toString())) {
                primeKeyPublic.set(s.toString())
            }
        }
    }
}