package br.com.brq.listdelivery.ui.pedidos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PedidosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Pagina de pedidos teste"
    }
    val text: LiveData<String> = _text
}