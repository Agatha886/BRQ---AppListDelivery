package br.com.brq.listdelivery.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.brq.listdelivery.PrincipalActivity
import br.com.brq.listdelivery.R
import br.com.brq.listdelivery.model.dataClasse.Tarefas
import com.google.android.material.snackbar.Snackbar


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

            if(validarTarefa(editTextNomeDoProduto.text.toString(),editTextDescricao.text.toString(),editTextDestinatario.text.toString(),editTextEndereco.text.toString(),editTextCpfDoCliente.text.toString(),editTextData.text.toString(),editTextObs.text.toString())){
                addItemLista(Tarefas.NovaTarefa(editTextNomeDoProduto,editTextDescricao,editTextDestinatario,editTextEndereco,editTextCpfDoCliente,editTextData,editTextObs))
                finish()
            } else {
                Snackbar.make(findViewById(R.id.CriarTarefaLayout),"Os espaços não vem estar em branco",Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    fun addItemLista(tarefa : Tarefas){
        Tarefas.BancoDelistasTarefas.add(tarefa)
    }

    fun validarTarefa(nome:String,descricao:String,destinatario:String,endereco:String,cpf:String,data:String,obs:String):Boolean{
        return nome.isNotBlank()&&descricao.isNotBlank()&&destinatario.isNotBlank()&&endereco.isNotBlank()&&cpf.isNotBlank()&&data.isNotBlank()&&obs.isNotBlank()
    }

}