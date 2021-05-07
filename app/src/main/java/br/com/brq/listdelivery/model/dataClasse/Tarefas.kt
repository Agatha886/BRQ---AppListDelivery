package br.com.brq.listDelivery.model.dataClasse

import br.com.brq.listDelivery.model.ListasPedido
import br.com.brq.listDelivery.model.StatusPedido

data class Tarefas (
        val id : Int,
        val status : StatusPedido,
        val User : User,
        val dataDeEntrega : String,
        val pedido: Pedido,
        val obs: String
)