package br.com.brq.listDelivery.ui

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.widget.ImageView
=======
import android.widget.Button
>>>>>>> e4de64abb5b7f16d72a943626b473b97a8e0556d
import android.widget.TextView
import br.com.brq.listDelivery.R
import br.com.brq.listDelivery.model.StatusPedido
import br.com.brq.listDelivery.model.dataClasse.Tarefas

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

<<<<<<< HEAD
        var tituloView : TextView = findViewById(R.id.tituloView)
        var dateView : TextView = findViewById(R.id.dateView)
        var statusView: TextView = findViewById(R.id.statusView)
        var nomeDestinatarioView : TextView = findViewById(R.id.nomeDestinatarioView)
        var cpfView : TextView = findViewById(R.id.cpfView)
        var enderecoView : TextView = findViewById(R.id.enderecoView)
        var descView : TextView = findViewById(R.id.descView)
        var imgTarefa : ImageView = findViewById(R.id.imageTarefaItem)
=======
        carregarElementos()
        carregarEventos()
>>>>>>> e4de64abb5b7f16d72a943626b473b97a8e0556d


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

<<<<<<< HEAD
//        imgTarefa.setImageURI("@drawable/tarefa_entregue")

    }

=======
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

>>>>>>> e4de64abb5b7f16d72a943626b473b97a8e0556d
}