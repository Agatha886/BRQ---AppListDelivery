package br.com.brq.listDelivery.model.dataClasse

import br.com.brq.listDelivery.model.StatusPedido
import java.io.Serializable

data class Tarefas(
        val status: StatusPedido,
        var User: User?,
        val dataDeEntrega: String,
        val pedido: Pedido,
        val obs: String,

):Serializable{
    companion object{
//        val listasTarefas = hashMapOf<Int, Tarefas>()
    }

}