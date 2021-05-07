package br.com.brq.listDelivery.model

import br.com.brq.listDelivery.model.dataClasse.Pedido
import br.com.brq.listDelivery.model.dataClasse.Tarefas

class ListasTarefas (){
    lateinit var listaPedido : ListasPedido
//    Tarefas

    val tarefa1 = Tarefas(
            id = 1,
            status = StatusPedido.PENDENTE,
            idUser = 1,
            dataDeEntrega ="2021-01-01",
            pedidoId= listaPedido.pedido1,
            obs="Produto com defeito"
    )

   val tarefa2 = Tarefas(
            id = 2,
            status = StatusPedido.PENDENTE,
            idUser = 1,
            dataDeEntrega ="2021-01-02",
            pedidoId= listaPedido.pedido2,
            obs="Produto com defeito"
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
        cpdDoDestinatario = "45699875563"
    )

    val pedido2 = Pedido(
       nomeDoProduto = "Liquidificador Mondial",
       descricaoDoProduto = "Liquidificador Mondial Turbo Power L-99 FB com 3 Velocidades 500W – Preto",
       enderecoEntrega = "R. Anatólia, 290 - Boaçava, São Paulo - SP, 05471-000",
       destinatario = "Francisco de Oliveira",
       cpdDoDestinatario = "45699875563"
    )
}
