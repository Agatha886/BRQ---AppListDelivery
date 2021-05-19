package br.com.brq.listDelivery.model

import br.com.brq.listDelivery.R
import br.com.brq.listDelivery.model.dataClasse.Pedido
import br.com.brq.listDelivery.model.dataClasse.Tarefas
import br.com.brq.listDelivery.model.dataClasse.User

class CarregarListas {
    fun carregarListas(){

//  Usuários
        User.listaUser.add(User("agathamonfredini@gmail.com","123","Agatha Monfredini","14788965523"))
        User.listaUser.add(User("alexalves@gmail.com","123","Alex Alves","78955632258"))
        User.listaUser.add(User("mariajoaquina@gmail.com","Maria@741", "Maria Joaquina","78955423365"))

//  Pedidos
        Pedido.listasPedido.add(Pedido("Aspirador de Água e Pó","Aspirador de Água e Pó Electrolux Hidrolux AWD01 1250W","Maria Joaquina","Avenida Queiroz Filho - Vila Hamburguesa, São Paulo - SP, 05319-000","45699875563"))
        Pedido.listasPedido.add(Pedido("Liquidificador Mondial","Liquidificador Mondial Turbo Power L-99 FB com 3 Velocidades 500W – Preto","Francisco da Cruz","R. Anatólia, 290 - Boaçava, São Paulo - SP, 05471-000","74266895531"))
        Pedido.listasPedido.add(Pedido("Fone de Ouvido Bluetooth","Fone de Ouvido Bluetooth JBL Tune 115BT - Preto","Fátima do Carmo","R. Dr. Tomás Alves, 87 - Vila Mariana, São Paulo - SP, 04017-070","7418936625"))
        Pedido.listasPedido.add(Pedido("Jogo de Soquetes","Jogo de Soquetes Tramontina em Aço Cromo Vanádio - 22 Peças","Rodrigo da Silva Antônio","R. Dr. Tomás Alves, 87 - Vila Mariana, São Paulo - SP, 04017-070","7418936625"))
//  Tarefas:
        Tarefas.listasTarefas.add(Tarefas(1,StatusPedido.PENDENTE, User.listaUser[0],"2021-01-01",Pedido.listasPedido[0],"",R.drawable.tarefa_pendente))
        Tarefas.listasTarefas.add(Tarefas(2,StatusPedido.ATRASADO, User.listaUser[1],"2021-01-02",Pedido.listasPedido[1],"",R.drawable.tarefa_atrasada))
        Tarefas.listasTarefas.add(Tarefas(3,StatusPedido.CANCELADO, User.listaUser[1],"2021-01-01",Pedido.listasPedido[2],"Produto com defeito",R.drawable.tarefa_cancelada))
        Tarefas.listasTarefas.add(Tarefas(4,StatusPedido.ENTREGUE, User.listaUser[0],"2021-01-02",Pedido.listasPedido[3], "",R.drawable.tarefa_entregue))
    }


//    fun imgStatus(): Int {
//        var img : Int
//
//        var listaTarefas = Tarefas.listasTarefas
//        for (tarefas in listaTarefas){
//            if(tarefas.status== StatusPedido.PENDENTE){
//                img = R.drawable.tarefa_pendente
//            }else if(tarefas.status == StatusPedido.ENTREGUE) {
//                img = R.drawable.tarefa_entregue
//            }else if(tarefas.status == StatusPedido.ATRASADO){
//                img = R.drawable.tarefa_atrasada
//            }else{
//                img = R.drawable.tarefa_cancelada
//            }
//        }
//        return img
//    }

}
