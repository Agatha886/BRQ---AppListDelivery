package br.com.brq.listdelivery.ui.cancelados

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CanceladosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento dos cancelados teste"
    }
    val text: LiveData<String> = _text
}