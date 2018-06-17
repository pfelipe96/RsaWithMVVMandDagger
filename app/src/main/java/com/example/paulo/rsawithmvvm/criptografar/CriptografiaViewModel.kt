package com.example.paulo.rsawithmvvm.criptografar

import android.databinding.BindingAdapter
import android.databinding.BindingMethod
import android.databinding.BindingMethods
import android.databinding.ObservableField
import android.support.design.widget.TextInputLayout
import android.text.Editable
import android.text.TextWatcher

@BindingMethods(BindingMethod(type = TextInputLayout::class, attribute = "app:setError", method = "showError"))
class CriptografiaViewModel: CriptografiaViewHolderInterface {

    val keyPublic = ObservableField<String>()
    val firstPrime = ObservableField<String>()
    val secondPrime = ObservableField<String>()


    val watcherFirstPrime: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }

    val watcherSecondPrime: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
    }
}