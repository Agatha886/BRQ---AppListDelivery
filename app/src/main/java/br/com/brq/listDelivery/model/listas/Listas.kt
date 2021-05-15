package br.com.brq.listDelivery.model

import br.com.brq.listDelivery.model.dataClasse.Pedido
import br.com.brq.listDelivery.model.dataClasse.Tarefas
import br.com.brq.listDelivery.model.dataClasse.User

class ListasTarefas (){

    var listaPedido = ListasPedido()


//        Tarefas

    val tarefa1 = Tarefas(
            status = StatusPedido.PENDENTE,
            User = User.listaUser.get(1),
            dataDeEntrega ="2021-01-01",
            pedido = listaPedido.pedido1,
            obs =""
    )

   val tarefa2 = Tarefas(

            status = StatusPedido.ATRASADO,
            User = User.listaUser.get(2),
            dataDeEntrega ="2021-01-02",
            pedido= listaPedido.pedido2,
            obs="",
    )

    val tarefa3 = Tarefas(

            status = StatusPedido.CANCELADO,
            User = User.listaUser.get(2),
            dataDeEntrega ="2021-01-01",
            pedido= listaPedido.pedido3,
            obs="Produto com defeito",
    )

    val tarefa4 = Tarefas(
            status = StatusPedido.ENTREGUE,
            User = User.listaUser.get(1),
            dataDeEntrega ="2021-01-02",
            pedido= listaPedido.pedido4,
            obs="",
    )



    val listaTarefas : MutableList<Tarefas> = mutableListOf(tarefa1,tarefa2)

    fun filtroListaTarefas(){
        listOf<String>("agathamonfredini@gmail.com","alexalves@gmail.com","mariajoaquina@gmail.com")
                .filterIndexed { index, _ ->  index== 0 }
                .forEach { println("                               " + it +"                                            ") }
    }



    fun imprimeTarefa(){
        val lista = listaTarefas.joinToString(separator = "\n"){
            "- ${it.dataDeEntrega}"
        }
//        textView.text = lista
    }
}

class ListasPedido(){
    val pedido1 = Pedido(
        nomeDoProduto = "Aspirador de Água e Pó",
        descricaoDoProduto = "Aspirador de Água e Pó Electrolux Hidrolux AWD01 1250W",
        enderecoEntrega = "Avenida Queiroz Filho - Vila Hamburguesa, São Paulo - SP, 05319-000",
        destinatario = "Maria Joaquina",
        cpfDoDestinatario = "45699875563"
    )

    val pedido2 = Pedido(
       nomeDoProduto = "Liquidificador Mondial",
       descricaoDoProduto = "Liquidificador Mondial Turbo Power L-99 FB com 3 Velocidades 500W – Preto",
       enderecoEntrega = "R. Anatólia, 290 - Boaçava, São Paulo - SP, 05471-000",
       destinatario = "Francisco da Cruz",
       cpfDoDestinatario = "74266895531"
    )

    val pedido3 = Pedido(
            nomeDoProduto = "Fone de Ouvido Bluetooth",
            descricaoDoProduto = "Fone de Ouvido Bluetooth JBL Tune 115BT - Preto",
            enderecoEntrega = "Rua Vergueiro, 2850 - Vila Mariana, São Paulo - SP",
            destinatario = "Fátima do Carmo",
            cpfDoDestinatario = "74566259963"
    )

    val pedido4 = Pedido(
            nomeDoProduto = "Jogo de Soquetes",
            descricaoDoProduto = "Jogo de Soquetes Tramontina em Aço Cromo Vanádio - 22 Peças",
            enderecoEntrega = "R. Dr. Tomás Alves, 87 - Vila Mariana, São Paulo - SP, 04017-070",
            destinatario = "Rodrigo da Silva Antônio",
            cpfDoDestinatario = "7418936625"
    )
}

class ListaUser(){

    //    Usuários


     var user1 = User(
//        id = 1,
        email = "agathamonfredini@gmail.com",
        senha = "123",
        nome = "Agatha Monfredini",
        cpf = "47877569986"
    )
    var user2 =  User(
//        id = 2,
        email = "alexalves@gmail.com",
        senha = "123",
        nome = "Alex Alves",
        cpf = "46977822356"
    )
}