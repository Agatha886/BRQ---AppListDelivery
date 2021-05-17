package br.com.brq.listDelivery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.com.brq.listDelivery.R

class DetalhesItemActivity : AppCompatActivity() {

lateinit var btnEntregue : Button
lateinit var btnAtrasado : Button
lateinit var btnCancelado : Button
lateinit var btnPendente : Button
lateinit var tituloView : TextView
lateinit var dateView : TextView
lateinit var statusView : TextView
lateinit var nomeDestinatarioView : TextView
lateinit var cpfView : TextView
lateinit var enderecoView : TextView
lateinit var descView : TextView
lateinit var obsView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_item)

        carregarElementos()
        carregarEventos()


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

        var obs = intent.extras?.get("obs")
        obsView.text = "Observação: ${obs.toString()}"
        println(obs.toString())

    }

    fun carregarElementos() {
        btnEntregue = findViewById(R.id.buttonEntregue)
        btnAtrasado = findViewById(R.id.buttonAtrasado)
        btnPendente = findViewById(R.id.buttonPendente)
        btnCancelado = findViewById(R.id.buttonCancelado)

        tituloView = findViewById(R.id.tituloView)
        dateView = findViewById(R.id.dateView)
        statusView = findViewById(R.id.statusView)
        nomeDestinatarioView = findViewById(R.id.nomeDestinatarioView)
        cpfView = findViewById(R.id.cpfView)
        enderecoView = findViewById(R.id.enderecoView)
        descView = findViewById(R.id.descView)
        obsView = findViewById(R.id.obsView)

    }

    fun carregarEventos(){
        btnEntregue.setOnClickListener(){

        }

    }

}