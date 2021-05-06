package br.com.brq.listDelivery.model

class Listas (): {

//    Usuários

    val user1 = User(
        id = 1,
        email = "agathamonfredini@gmail.com",
        senha = "123",
        nome = "Agatha Monfredini",
        cpf = "47877569986"

    )



//    Tarefas
    val tarefa1 = Tarefas(
            id = 1,
            status = StatusPedido.PENDENTE,
            idUser = 1,
            dataDeEntrega ="2021-01-01",
            pedidoId= 1,
            obs=" "
    )

    val tarefa2 = Tarefas(
            id = 2,
            status = StatusPedido.PENDENTE,
            idUser = 1,
            dataDeEntrega ="2021-01-02",
            pedidoId= 2,
            obs="Produto com defeito"
    )
}