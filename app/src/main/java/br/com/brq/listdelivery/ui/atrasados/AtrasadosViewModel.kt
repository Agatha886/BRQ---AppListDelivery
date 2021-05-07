package br.com.brq.listdelivery.ui.atrasados

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AtrasadosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento dos atrasados teste"
    }
    val text: LiveData<String> = _text
}