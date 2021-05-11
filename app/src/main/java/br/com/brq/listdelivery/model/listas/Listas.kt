package br.com.brq.listDelivery.model

import androidx.annotation.DrawableRes
import br.com.brq.listDelivery.R
import br.com.brq.listDelivery.model.dataClasse.Pedido
import br.com.brq.listDelivery.model.dataClasse.Tarefas
import br.com.brq.listDelivery.model.dataClasse.User

class ListasTarefas (){

    var listaPedido = ListasPedido()
    var listaUser = ListaUser()

//        Tarefas

    val tarefa1 = Tarefas(
            id = 1,
            status = StatusPedido.PENDENTE,
            User = listaUser.user1,
            dataDeEntrega ="2021-01-01",
            pedido = listaPedido.pedido1,
            obs =""
    )

   val tarefa2 = Tarefas(
            id = 2,
            status = StatusPedido.ATRASADO,
            User = listaUser.user2,
            dataDeEntrega ="2021-01-02",
            pedido= listaPedido.pedido2,
            obs="",
    )

    val tarefa3 = Tarefas(
            id = 3,
            status = StatusPedido.CANCELADO,
            User = listaUser.user1,
            dataDeEntrega ="2021-01-01",
            pedido= listaPedido.pedido3,
            obs="Produto com defeito",
    )

    val tarefa4 = Tarefas(
            id = 4,
            status = StatusPedido.ENTREGUE,
            User = listaUser.user2,
            dataDeEntrega ="2021-01-02",
            pedido= listaPedido.pedido4,
            obs="",
    )


//    val listaTarefas : MutableList<Tarefas> = mutableListOf(tarefa1,tarefa2)

    fun filtroListaTarefas(){
        listOf<String>("agathamonfredini@gmail.com","alexalves@gmail.com","mariajoaquina@gmail.com")
                .filterIndexed { index, _ ->  index== 0 }
                .forEach { println("                               " + it +"                                            ") }
    }

    fun imgListaTarefa(tarefa: Tarefas): Int {
        if(tarefa.status == StatusPedido.PENDENTE){
           return R.drawable.tarefa_atrasada
        }

        if(tarefa.status == StatusPedido.ENTREGUE){
            return R.drawable.tarefa_entregue
        }
        return R.drawable.tarefa_cancelada
    }



//    fun imprimeTarefa(){
//        val lista = listaTarefas.joinToString(separator = "\n"){
//            "- ${it.dataDeEntrega}"
//        }
////        textView.text = lista
//    }
}

class ListasPedido(){
    val pedido1 = Pedido(
        nomeDoProduto = "Aspirador de Água e Pó",
        descricaoDoProduto = "Aspirador de Água e Pó Electrolux Hidrolux AWD01 1250W",
        enderecoEntrega = "Avenida Queiroz Filho - Vila Hamburguesa, São Paulo - SP, 05319-000",
        destinatario = "Maria Joaquina",
        cpdDoDestinatario = "45699875563"
    )

    val pedido2 = Pedido(
       nomeDoProduto = "Liquidificador Mondial",
       descricaoDoProduto = "Liquidificador Mondial Turbo Power L-99 FB com 3 Velocidades 500W – Preto",
       enderecoEntrega = "R. Anatólia, 290 - Boaçava, São Paulo - SP, 05471-000",
       destinatario = "Francisco de Oliveira",
       cpdDoDestinatario = "74266895531"
    )

    val pedido3 = Pedido(
            nomeDoProduto = "Fone de Ouvido Bluetooth",
            descricaoDoProduto = "Fone de Ouvido Bluetooth JBL Tune 115BT - Preto",
            enderecoEntrega = "Rua Vergueiro, 2850 - Vila Mariana, São Paulo - SP",
            destinatario = "Fátima do Carmo",
            cpdDoDestinatario = "74566259963"
    )

    val pedido4 = Pedido(
            nomeDoProduto = "Jogo de Soquetes",
            descricaoDoProduto = "Jogo de Soquetes Tramontina em Aço Cromo Vanádio - 22 Peças",
            enderecoEntrega = "R. Dr. Tomás Alves, 87 - Vila Mariana, São Paulo - SP, 04017-070",
            destinatario = "Rodrigo da Silva Antônio",
            cpdDoDestinatario = "7418936625"
    )
}

class ListaUser(){

    //    Usuários

     var user1 = User(
        id = 1,
        email = "agathamonfredini@gmail.com",
        senha = "123",
        nome = "Agatha Monfredini",
        cpf = "47877569986"
    )
    var user2 =  User(
        id = 2,
        email = "alexalves@gmail.com",
        senha = "123",
        nome = "Alex Alves",
        cpf = "46977822356"
    )

}
