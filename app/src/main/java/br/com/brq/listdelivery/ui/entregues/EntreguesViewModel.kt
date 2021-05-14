package br.com.brq.listdelivery.ui.entregues

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EntreguesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento de pedidos entregues teste"
    }
    val text: LiveData<String> = _text
}