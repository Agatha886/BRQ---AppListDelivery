package br.com.brq.listDelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listDelivery.model.AdapterRecyclerView
import br.com.brq.listDelivery.model.ItemClickListener
import br.com.brq.listDelivery.model.dataClasse.Tarefas
import br.com.brq.listDelivery.model.dataClasse.User
import br.com.brq.listDelivery.ui.CriarTarefaActivity
import br.com.brq.listDelivery.ui.DetalhesItemActivity
import kotlin.collections.ArrayList


class PrincipalActivity : AppCompatActivity(), ItemClickListener {
    var recyclerView: RecyclerView? = null
    lateinit var listaFiltada: ArrayList<Tarefas>
    lateinit var textViewSemTarefa: TextView
    lateinit var btnSair : Button
    lateinit var textViewBemVindo: TextView

    var criarTarefa: View? = null
    var adapter: AdapterRecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        carregarElementos()
        carregarEventos()
        filtrarLlista()
        mensagemSemTarefas()

        AdapterRecyclerView(this, listaFiltada,this).let {
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
        btnSair = findViewById(R.id.btn_sair)
        textViewBemVindo = findViewById(R.id.textViewBemVindUser)
    }

    fun carregarEventos() {
        criarTarefa?.setOnClickListener {
            val intentTelaCriarTarefa = Intent(this, CriarTarefaActivity::class.java)
            startActivity(intentTelaCriarTarefa)
        }

        btnSair.setOnClickListener {
            val intentTelaLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentTelaLogin)
        }

        textViewBemVindo.text = "Bem vindo: ${User.user.nome}"

    }

    fun filtrarLlista() {
        listaFiltada = Tarefas.listasTarefas.filter {
            (it.User!!.email == User.user.email)
        } as ArrayList<Tarefas>
    }

    fun mensagemSemTarefas(){
        if (listaFiltada.size == 0){
            textViewSemTarefa.text = "Não há Tarefas"
        }else{
            textViewSemTarefa.text = " "
        }
    }

    override fun onClickItem(view: View?, index: Int) {

        var intent = Intent(this, DetalhesItemActivity::class.java)
        var item = listaFiltada[index]
        intent.putExtra("destinatario",item.pedido?.destinatario)
        intent.putExtra("data",item.dataDeEntrega)
        intent.putExtra("status",item.status)
        intent.putExtra("nomeProduto",item.pedido?.nomeDoProduto)
        intent.putExtra("cpfDestinatario",item.pedido?.cpfDoDestinatario)
        intent.putExtra("endereco",item.pedido?.enderecoEntrega)
        intent.putExtra("descProduto",item.pedido?.descricaoDoProduto)
        startActivity(intent)

//        adapter?.remoteItem(index)
    }
//
//    override fun onClickItem(view: View?, index: Int) {
//        val intent = Intent(this, DetalhesActivity::class.java)
//        intent.putExtra("parametro_nome", meuArrayDeAnimais[index].nome)
//        intent.putExtra("parametro_objeto", meuArrayDeAnimais[index])
//        startActivity(intent)
//    }

    override fun onLongClickItem(view: View?, index: Int):Boolean {
        adapter?.remoteItem(index)
//        Tarefas.listasTarefas.removeAt(index)
        return true
    }

}
