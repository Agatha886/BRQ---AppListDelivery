package br.com.brq.listDelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listDelivery.model.AdapterRecyclerView
import br.com.brq.listDelivery.model.ListasTarefas
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

        AdapterRecyclerView(this, listasTarefas).let {
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
        val tarefa = ListasTarefas()
        listasTarefas = ArrayList()
        listasTarefas.add(tarefa.tarefa1)
        listasTarefas.add(tarefa.tarefa2)
        listasTarefas.add(tarefa.tarefa3)
        listasTarefas.add(tarefa.tarefa4)
    }



}
