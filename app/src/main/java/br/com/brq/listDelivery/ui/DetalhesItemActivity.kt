package br.com.brq.listDelivery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import br.com.brq.listDelivery.R

class DetalhesItemActivity : AppCompatActivity() {
=======
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import br.com.brq.listDelivery.R
import org.w3c.dom.Text

class DetalhesItemActivity : AppCompatActivity() {





>>>>>>> 475214104e524f1acb9decc0c9beb921ee5ed5c1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_item)

<<<<<<< HEAD
=======
        var tituloView : TextView = findViewById(R.id.tituloView)
        var dateView : TextView = findViewById(R.id.dateView)
        var statusView: TextView = findViewById(R.id.statusView)
        var nomeDestinatarioView : TextView = findViewById(R.id.nomeDestinatarioView)
        var cpfView : TextView = findViewById(R.id.cpfView)
        var enderecoView : TextView = findViewById(R.id.enderecoView)
        var descView : TextView = findViewById(R.id.descView)


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

>>>>>>> 475214104e524f1acb9decc0c9beb921ee5ed5c1


    }
}