package br.com.brq.listDelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listDelivery.model.AdapterRecyclerView
import br.com.brq.listDelivery.model.StatusPedido
import br.com.brq.listDelivery.model.dataClasse.Pedido
import br.com.brq.listDelivery.model.dataClasse.Tarefas
import br.com.brq.listDelivery.model.dataClasse.User


class PrincipalActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    lateinit var listasTarefas: ArrayList<Tarefas>
    var criarTarefa : View? = null
    var adapter: AdapterRecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        carregarElementos()
        carregarEventos()
        carregarListas()


        AdapterRecyclerView(this, Tarefas.listasTarefas).let {
            adapter = it
            recyclerView?.adapter = it
        }

        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    fun carregarElementos() {
        recyclerView = findViewById(R.id.rv_tarefas)
        criarTarefa = findViewById(R.id.tarefaAdd)
    }

    fun carregarEventos() {
        var pedido = Pedido(
                nomeDoProduto = "teste",
                descricaoDoProduto = "teste",
                destinatario = "teste",
                enderecoEntrega = "teste",
                cpfDoDestinatario = "teste"
        )

        criarTarefa?.setOnClickListener{
//            val int = Intent(this, CriarTarefaActivity::class.java)
//            startActivity(int)
//            adapter?.addItemLista(Tarefas(StatusPedido.PENDENTE,"01-02-2021", pedido," "))
        }
    }

    fun carregarListas(){
        var user = User.listaUses.get(1)
//        val tarefa = ListasTarefas()
//        listasTarefas = ArrayList()
//        listasTarefas.add(tarefa.tarefa1)
//        listasTarefas.add(tarefa.tarefa2)
//        listasTarefas.add(tarefa.tarefa3)
//        listasTarefas.add(tarefa.tarefa4)
        val pedido1 = Pedido(
                nomeDoProduto = "Aspirador de Água e Pó",
                descricaoDoProduto = "Aspirador de Água e Pó Electrolux Hidrolux AWD01 1250W",
                enderecoEntrega = "Avenida Queiroz Filho - Vila Hamburguesa, São Paulo - SP, 05319-000",
                destinatario = "Maria Joaquina",
                cpfDoDestinatario = "45699875563"
        )
        var user1 = User(
//        id = 1,
                email = "agathamonfredini@gmail.com",
                senha = "123",
                nome = "Agatha Monfredini",
                cpf = "47877569986"
        )

        Tarefas.listasTarefas.put(1,Tarefas(StatusPedido.PENDENTE,user1,"02-03-2021",pedido1," "))
    }


}
