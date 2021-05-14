package br.com.brq.listdelivery.model

class Tarefas (
        var id : String,
        var usuario : User,
        var status : StatusPedido,
        var dataEntrega : String,
        var pedido : Pedido,
        var observacao : String
){
    //Metodos para tarefas
}