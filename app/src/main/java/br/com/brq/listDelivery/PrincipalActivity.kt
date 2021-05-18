package br.com.brq.listDelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listDelivery.model.AdapterRecyclerView
import br.com.brq.listDelivery.model.ItemClickListener
import br.com.brq.listDelivery.model.StatusPedido
import br.com.brq.listDelivery.model.dataClasse.Tarefas
import br.com.brq.listDelivery.model.dataClasse.User
import br.com.brq.listDelivery.ui.CriarTarefaActivity
import br.com.brq.listDelivery.ui.DetalhesItemActivity
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
        mensagemSemTarefas()
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
            filtrarLista()
            val listEntregue = listaFiltada.filter {
                 (it.status == StatusPedido.ENTREGUE)
            }as ArrayList<Tarefas>

            filtroStatus(listEntregue)
        }

        btnFiltrarPendente?.setOnClickListener {
            filtrarLista()
           val listPendente = listaFiltada.filter {
                (it.status == StatusPedido.PENDENTE)
            }as ArrayList<Tarefas>

            filtroStatus(listPendente)
        }

        btnFiltrarCancelado?.setOnClickListener {
            filtrarLista()
            val listCancelado = listaFiltada.filter {
                (it.status == StatusPedido.CANCELADO)
            }as ArrayList<Tarefas>

            filtroStatus(listCancelado)
        }

        btnFiltrarAtrasado?.setOnClickListener {
            filtrarLista()
            val listAtrasado = listaFiltada.filter {
                (it.status == StatusPedido.ATRASADO)
            }as ArrayList<Tarefas>
            
            filtroStatus(listAtrasado)
        }

        btnTodasTarefas?.setOnClickListener {
                filtrarLista()
                adapter?.addLista(listaFiltada)
                mensagemSemTarefas()
        }
    }
    
    fun filtroStatus(listStatus: ArrayList<Tarefas>){
        adapter?.updateList(listStatus)

        if(listStatus.size == 0){
            textViewSemTarefa.text = "Não há Tarefas"
        }else{
            textViewSemTarefa.text = " "
        }
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
