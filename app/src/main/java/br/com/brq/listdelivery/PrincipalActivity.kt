package br.com.brq.listdelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listdelivery.model.AdapterRecyclerView
import br.com.brq.listdelivery.model.ItemClickListener
import br.com.brq.listdelivery.model.StatusPedido
import br.com.brq.listdelivery.model.dataClasse.Tarefas
import br.com.brq.listdelivery.model.dataClasse.User
import br.com.brq.listdelivery.ui.CriarTarefaActivity
import br.com.brq.listdelivery.ui.DetalhesItemActivity
import kotlin.collections.ArrayList


class PrincipalActivity : AppCompatActivity(), ItemClickListener {

    var recyclerView: RecyclerView? = null
    var adapter: AdapterRecyclerView? = null
    lateinit var listaFiltada: ArrayList<Tarefas>

    lateinit var textViewBemVindo: TextView
    lateinit var textViewSemTarefa: TextView

    lateinit var btnSair : Button
    var btnCriarTarefa: View? = null
    var btnTodasTarefas: View? = null
    var btnFiltrarEntregue : View? = null
    var btnFiltrarPendente : View? = null
    var btnFiltrarCancelado : View? = null
    var btnFiltrarAtrasado : View? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        carregarElementos()
        carregarEventos()
        filtrarLista()
        mensagemSemTarefas(listaFiltada)
        filtrarListaStatus()

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
        textViewSemTarefa = findViewById(R.id.textViewSemTarefas)
        listaFiltada = ArrayList()
        textViewBemVindo = findViewById(R.id.textViewBemVindUser)

        btnSair = findViewById(R.id.btn_sair)
        btnCriarTarefa = findViewById(R.id.tarefaAdd)
        btnTodasTarefas = findViewById(R.id.tarefaVoltar)
        btnFiltrarEntregue = findViewById(R.id.buttonFiltrarEntregue)
        btnFiltrarAtrasado = findViewById(R.id.buttonFiltrarAtrasado)
        btnFiltrarCancelado = findViewById(R.id.buttonFiltrarCancelado)
        btnFiltrarPendente = findViewById(R.id.buttonFiltrarPendente)

    }

    fun carregarEventos() {
        btnCriarTarefa?.setOnClickListener {
            val intentTelaCriarTarefa = Intent(this, CriarTarefaActivity::class.java)
            startActivity(intentTelaCriarTarefa)
        }

        btnSair.setOnClickListener {
            val intentTelaLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentTelaLogin)
        }

        textViewBemVindo.text = "Bem vindo: ${User.user.nome}"

    }

    fun filtrarLista() {
        listaFiltada = Tarefas.listasTarefas.filter {
            (it.User!!.email == User.user.email)
        } as ArrayList<Tarefas>
    }

    fun filtrarListaStatus(){
        btnFiltrarEntregue?.setOnClickListener {
            filtroStatus(StatusPedido.ENTREGUE)
        }

        btnFiltrarPendente?.setOnClickListener {
            filtroStatus(StatusPedido.PENDENTE)
        }

        btnFiltrarCancelado?.setOnClickListener {
            filtroStatus(StatusPedido.CANCELADO)
        }

        btnFiltrarAtrasado?.setOnClickListener {
            filtroStatus(StatusPedido.ATRASADO)
        }

        btnTodasTarefas?.setOnClickListener {
                filtrarLista()
                adapter?.addLista(listaFiltada)
                mensagemSemTarefas(listaFiltada)
        }
    }
    
    fun filtroStatus(status: StatusPedido){
        filtrarLista()

       val listStatus = listaFiltada.filter {
            (it.status == status)
        }as ArrayList<Tarefas>

        adapter?.updateList(listStatus)

        mensagemSemTarefas(listStatus)
    }

    fun mensagemSemTarefas(list: ArrayList<Tarefas>){
        if (list.size == 0){
            textViewSemTarefa.text = "Não há Tarefas"
        }else{
            textViewSemTarefa.text = " "
        }
    }

    override fun onClickItem(view: View?, index: Int) {

        var intent = Intent(this, DetalhesItemActivity::class.java)
        var item = listaFiltada[index]

        intent.putExtra("item",item)
        intent.putExtra("destinatario",item.pedido?.destinatario)
        intent.putExtra("data",item.dataDeEntrega)
        intent.putExtra("status",item.status)
        intent.putExtra("nomeProduto",item.pedido?.nomeDoProduto)
        intent.putExtra("cpfDestinatario",item.pedido?.cpfDoDestinatario)
        intent.putExtra("endereco",item.pedido?.enderecoEntrega)
        intent.putExtra("descProduto",item.pedido?.descricaoDoProduto)
        intent.putExtra("obs",item.obs)
        intent.putExtra("img",item.photo)
        intent.putExtra("index",index)
        startActivity(intent)

    }

    override fun onLongClickItem(view: View?, index: Int):Boolean {
        adapter?.remoteItem(index)
        return true
    }

    override fun onClickButtonDelete(view: View?, index: Int) {
        for (tarefas in Tarefas.listasTarefas){
            if(listaFiltada[index] == tarefas){
                Tarefas.listasTarefas.remove(tarefas)
                adapter?.remoteItem(index)
            }
        }
    }

}
