package br.com.brq.listdelivery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import br.com.brq.listdelivery.R
import br.com.brq.listdelivery.model.AdapterRecyclerView
import br.com.brq.listdelivery.model.StatusPedido

class DetalhesItemActivity : AppCompatActivity() {

    var btnEntregue: View? = null
    var btnAtrasado:   View? = null
    var btnCancelado: View? = null
    var btnPendente: View? = null
    var adapter: AdapterRecyclerView? = null

    lateinit var imgTarefa : ImageView
    lateinit var tituloView: TextView
    lateinit var dateView: TextView
    lateinit var statusView: TextView
    lateinit var nomeDestinatarioView: TextView
    lateinit var cpfView: TextView
    lateinit var enderecoView: TextView
    lateinit var descView: TextView
    lateinit var obsView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_item)

//        var tituloView: TextView = findViewById(R.id.tituloView)
//        var dateView: TextView = findViewById(R.id.dateView)
//        var statusView: TextView = findViewById(R.id.statusView)
//        var nomeDestinatarioView: TextView = findViewById(R.id.nomeDestinatarioView)
//        var cpfView: TextView = findViewById(R.id.cpfView)
//        var enderecoView: TextView = findViewById(R.id.enderecoView)
//        var descView: TextView = findViewById(R.id.descView)
//        var imgTarefa: ImageView = findViewById(R.id.imageTarefa)

        carregarElementos()

        var index: Int = intent.extras?.get("index") as Int

        var produto = intent.extras?.get("nomeProduto")
        tituloView.text = "Produto: ${produto.toString()}"

        var data = intent.extras?.get("data")
        dateView.text = "Data: ${data.toString()}"

        var status = intent.extras?.get("status")
        statusView.text = "Status: ${status.toString()}"

        var pessoa = intent.extras?.get("destinatario")
        nomeDestinatarioView.text = "Destinatario: ${pessoa.toString()}"

        var cpf = intent.extras?.get("cpfDestinatario")
        cpfView.text = "CPF: ${cpf.toString()}"

        var endereco = intent.extras?.get("endereco")
        enderecoView.text = "Endereço: ${endereco.toString()}"

        var descricao = intent.extras?.get("descProduto")
        descView.text = "Descrição: ${descricao.toString()}"

        var photoTarefa = intent.extras?.get("img")
        imgTarefa.setImageResource(photoTarefa as Int)

        var obs = intent.extras?.get("obs")
        obsView.text = "Observação: ${obs.toString()}"
        println(obs.toString())



        carregarEventos(index)

    }


    fun carregarElementos() {
        btnEntregue = findViewById(R.id.buttonEntregue)
        btnAtrasado = findViewById(R.id.buttonAtrasado)
        btnPendente = findViewById(R.id.buttonPendente)
        btnCancelado = findViewById(R.id.buttonCancelado)

        imgTarefa= findViewById(R.id.imageTarefaItem)
        tituloView = findViewById(R.id.tituloView)
        dateView = findViewById(R.id.dateView)
        statusView = findViewById(R.id.statusView)
        nomeDestinatarioView = findViewById(R.id.nomeDestinatarioView)
        cpfView = findViewById(R.id.cpfView)
        enderecoView = findViewById(R.id.enderecoView)
        descView = findViewById(R.id.descView)
        obsView = findViewById(R.id.obsView)

    }

    fun carregarEventos(index: Int) {

        btnEntregue?.setOnClickListener {
            adapter?.setStatusEntregue(index)

            println(adapter?.listaTarefas?.get(index))

        }

    }
}


