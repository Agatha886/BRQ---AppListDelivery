package br.com.brq.listDelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listDelivery.model.AdapterRecyclerView
import br.com.brq.listDelivery.model.dataClasse.Tarefas
import br.com.brq.listDelivery.model.dataClasse.User
import br.com.brq.listDelivery.ui.CriarTarefaActivity
import kotlin.collections.ArrayList


class PrincipalActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    lateinit var listaFiltada: ArrayList<Tarefas>
    lateinit var textViewSemTarefa: TextView
    var criarTarefa: View? = null
    var adapter: AdapterRecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        carregarElementos()
        carregarEventos()
        filtrarLlista()
        mensagemSemTarefas()

        AdapterRecyclerView(this, listaFiltada).let {
            adapter = it
            recyclerView?.adapter = it
        }

        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    override fun onRestart() {
        super.onRestart()
            if(Tarefas.newTarefa != null){
                adapter?.addItemLista(Tarefas.newTarefa!!)
            }
    }

    fun carregarElementos() {
        recyclerView = findViewById(R.id.rv_tarefas)
        criarTarefa = findViewById(R.id.tarefaAdd)
        textViewSemTarefa = findViewById(R.id.textViewSemTarefas)
        listaFiltada = ArrayList()
    }

    fun carregarEventos() {
        criarTarefa?.setOnClickListener {
            val intentTelaCriarTarefa = Intent(this, CriarTarefaActivity::class.java)
            startActivity(intentTelaCriarTarefa)
        }
        mensagemSemTarefas()
    }


    fun filtrarLlista() {
        listaFiltada = Tarefas.listasTarefas.filter {
            (it.User!!.email == User.user.email)
        } as ArrayList<Tarefas>
        println(listaFiltada)
    }

    fun mensagemSemTarefas(){
        if (listaFiltada.size == 0){
            textViewSemTarefa.text = "Não há Tarefas"
        }else{
            textViewSemTarefa.text = " "
        }
    }



}
