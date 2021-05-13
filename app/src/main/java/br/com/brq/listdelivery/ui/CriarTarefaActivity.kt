package br.com.brq.listDelivery.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listDelivery.R
import br.com.brq.listDelivery.model.dataClasse.Pedido
import br.com.brq.listDelivery.model.dataClasse.Tarefas
import br.com.brq.listDelivery.model.AdapterRecyclerView as AdapterRecyclerView


class CriarTarefaActivity : AppCompatActivity(){
    lateinit var listasTarefas: ArrayList<Tarefas>
    lateinit var editTextData: EditText
    lateinit var editTextNomeDoProduto: EditText
    lateinit var editTextDescricao: EditText
    lateinit var editTextDestinatario: EditText
    lateinit var editTextEndereco: EditText
    lateinit var editTextCpfDoCliente: EditText
    lateinit var editTextObs: EditText
    lateinit var btnCriarTarefa : Button
    var adapter: AdapterRecyclerView? = null
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_tarefa)
        CarregarElementos()
        CarregarEventos()

        AdapterRecyclerView(this, listasTarefas).let {
            adapter = it
            recyclerView?.adapter = it
        }
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    fun CarregarElementos(){
        recyclerView = findViewById(R.id.rv_tarefas)
        btnCriarTarefa = findViewById(R.id.button_criar_tarefa)
        editTextData =findViewById(R.id.editTextData)
        editTextNomeDoProduto = findViewById(R.id.editTextNomeProduto)
        editTextDescricao = findViewById(R.id.editTextDescricao)
        editTextDestinatario = findViewById(R.id.editTextDestintario)
        editTextEndereco = findViewById(R.id.editTextEndereco)
        editTextCpfDoCliente = findViewById(R.id.editTextCpfCliente)
        editTextObs = findViewById(R.id.editTextObs)
    }

    fun CarregarEventos(){
        var pedido = Pedido(
                nomeDoProduto = "teste",
                descricaoDoProduto = "teste",
                destinatario = "teste",
                enderecoEntrega = "teste",
                cpfDoDestinatario = "teste"
        )

        btnCriarTarefa.setOnClickListener {
//            adapter?.addItemLista(Tarefas(StatusPedido.PENDENTE,"01-02-2021", pedido," "))
            val int = Intent(this, CriarTarefaActivity::class.java)
            startActivity(int)
        }
    }
//
//    fun NovaTarefa():Tarefas{
//
//         var pedido = Pedido(
//         nomeDoProduto = editTextNomeDoProduto.text.toString(),
//         descricaoDoProduto = editTextDescricao.text.toString(),
//         destinatario = editTextDestinatario.text.toString(),
//         enderecoEntrega = editTextEndereco.text.toString(),
//         cpfDoDestinatario = editTextCpfDoCliente.text.toString()
//        )
//
////        var newTarefa = Tarefas(
////        status = StatusPedido.PENDENTE,
////        pedido = pedido,
////        dataDeEntrega = editTextData.text.toString() ,
////        obs = editTextObs.text.toString()
////        )
//        return newTarefa
//    }


}