package br.com.brq.listDelivery.model

data class Tarefas (
    val id : Int,
    val status : StatusPedido,
    val idUser : Int,
    val dataDeEntrega : String,
    val pedidoId: Int,
    val obs: String
)