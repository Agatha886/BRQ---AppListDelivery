package br.com.brq.listDelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listDelivery.model.AdapterRecyclerView
import br.com.brq.listDelivery.model.ListasTarefas
import br.com.brq.listDelivery.model.StatusPedido
import br.com.brq.listDelivery.model.dataClasse.Tarefas


class PrincipalActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    lateinit var listasTarefas: ArrayList<Tarefas>
    lateinit var meuArray: ArrayList<Tarefas>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        carregarElementos()
        carregarListas()

        recyclerView?.adapter= AdapterRecyclerView(this,listasTarefas)
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    fun carregarElementos() {
        recyclerView = findViewById(R.id.rv_tarefas)
    }

    fun carregarEventos() {
        val tarefa = ListasTarefas()
//        conta.validTarefa(text)
//        tarefa.imprimeTarefa()
    }

    fun carregarListas(){
        val tarefa = ListasTarefas()
        listasTarefas = ArrayList()

        listasTarefas.add(tarefa.tarefa1)
        listasTarefas.add(tarefa.tarefa2)
    }


}
