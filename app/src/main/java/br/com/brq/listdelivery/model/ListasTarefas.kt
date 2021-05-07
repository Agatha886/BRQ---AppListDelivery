package br.com.brq.listDelivery.model

import android.widget.TextView

class Listas (){

//    //    Usuários
//
//    val ListaUser = listOf(
//
//     User(
//        id = 1,
//        email = "agathamonfredini@gmail.com",
//        senha = "123",
//        nome = "Agatha Monfredini",
//        cpf = "47877569986"
//    ),
//     User(
//        id = 2,
//        email = "alexalves@gmail.com",
//        senha = "123",
//        nome = "Alex Alves",
//        cpf = "46977822356"
//    )
//    )

//    Tarefas

    val tarefa1 =Tarefas(
            id = 1,
            status = StatusPedido.PENDENTE,
            idUser = 1,
            dataDeEntrega ="2021-01-01",
            pedidoId= 1,
            obs="Produto com defeito"
    )

   val tarefa2 = Tarefas(
            id = 2,
            status = StatusPedido.PENDENTE,
            idUser = 1,
            dataDeEntrega ="2021-01-02",
            pedidoId= 2,
            obs="Produto com defeito"
    )

    val listaTarefas : MutableList<Tarefas> = mutableListOf(tarefa1,tarefa2)

    fun filtroLista(){
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