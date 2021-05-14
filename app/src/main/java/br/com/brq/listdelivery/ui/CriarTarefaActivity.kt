package br.com.brq.listDelivery.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.brq.listDelivery.PrincipalActivity
import br.com.brq.listDelivery.R
import br.com.brq.listDelivery.model.dataClasse.Tarefas



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

    override fun onStart() {
        super.onStart()
        Tarefas.newTarefa = null
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
            addItemLista(Tarefas.NovaTarefa(editTextNomeDoProduto,editTextDescricao,editTextDestinatario,editTextEndereco,editTextCpfDoCliente,editTextData,editTextObs))
            val intentTelaPrincipal = Intent(this, PrincipalActivity::class.java)
            startActivity(intentTelaPrincipal)
        }
    }

    fun addItemLista(tarefa : Tarefas){
        Tarefas.listasTarefas.add(tarefa)
    }

}