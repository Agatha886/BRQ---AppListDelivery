package br.com.brq.listDelivery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.brq.listDelivery.R
import br.com.brq.listDelivery.model.StatusPedido
import br.com.brq.listDelivery.model.dataClasse.Pedido
import br.com.brq.listDelivery.model.dataClasse.Tarefas
import br.com.brq.listDelivery.model.dataClasse.User



class CriarTarefaActivity : AppCompatActivity(){
    lateinit var editTextData: EditText
    lateinit var editTextNomeDoProduto: EditText
    lateinit var editTextDescricao: EditText
    lateinit var editTextDestinatario: EditText
    lateinit var editTextEndereco: EditText
    lateinit var editTextCpfDoCliente: EditText
    lateinit var editTextObs: EditText
    lateinit var btnCriarTarefa : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_tarefa)
        CarregarElementos()
        CarregarEventos()
     }

    fun CarregarElementos(){
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

        btnCriarTarefa.setOnClickListener {
            addItemLista(NovaTarefa())
        }
    }

    fun addItemLista(tarefa : Tarefas){
        Tarefas.listasTarefas.add(tarefa)
    }

    fun NovaTarefa():Tarefas{

        var pedido = Pedido(
                nomeDoProduto = editTextNomeDoProduto.text.toString(),
                descricaoDoProduto = editTextDescricao.text.toString(),
                destinatario = editTextDestinatario.text.toString(),
                enderecoEntrega = editTextEndereco.text.toString(),
                cpfDoDestinatario = editTextCpfDoCliente.text.toString()
        )

        var newTarefa = Tarefas(   status = StatusPedido.PENDENTE,
                pedido = pedido,
                dataDeEntrega = editTextData.text.toString() ,
                obs = editTextObs.text.toString(),
                User = User.user
        )
        return newTarefa
    }


}