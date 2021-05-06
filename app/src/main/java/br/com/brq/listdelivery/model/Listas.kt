package br.com.brq.listDelivery.model

class Tarefas (
    var id : String,
//    var usuario : User,
    var status : StatusPedido,
    var dataEntrega : String,
    var pedido : Pedido,
    var observacao : String
){
    val tarefa1 = DcTarefas(
            id = 1,
            status = StatusPedido.PENDENTE,
            idUser = 1,
            dataDeEntrega ="2021-01-01",
            pedidoId= 1,
            obs=" "
    )

    val tarefa2 = DcTarefas(
            id = 2,
            status = StatusPedido.PENDENTE,
            idUser = 1,
            dataDeEntrega ="2021-01-02",
            pedidoId= 2,
            obs="Produto com defeito"
    )
}