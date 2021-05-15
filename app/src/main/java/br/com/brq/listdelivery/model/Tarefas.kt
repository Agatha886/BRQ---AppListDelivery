package br.com.brq.listdelivery.model

import android.widget.EditText
import java.io.Serializable

data class Tarefas(
        val status: StatusPedido,
        var User: User?,
        val dataEntrega: String,
        val pedido: Pedido?,
        val obs: String,

        ):Serializable{
        companion object{
                val listasTarefas = ArrayList<Tarefas>()
                var newTarefa : Tarefas? = null

                fun NovaTarefa(editTextNomeDoProduto: EditText,editTextDescricao:EditText,editTextDestinatario:EditText,editTextEndereco:EditText,editTextCpfDoCliente:EditText,
                               editTextData:EditText,editTextObs:EditText):Tarefas{

                        var pedido = Pedido(
                                nomeDoProduto = editTextNomeDoProduto.text.toString(),
                                descricaoDoProduto = editTextDescricao.text.toString(),
                                destinatario = editTextDestinatario.text.toString(),
                                enderecoEntrega = editTextEndereco.text.toString(),
                                cpfDoDestinatario = editTextCpfDoCliente.text.toString()
                        )

                        newTarefa = Tarefas(   status = StatusPedido.PENDENTE,
                                pedido = pedido,
                                dataEntrega = editTextData.text.toString() ,
                                obs = editTextObs.text.toString(),
                                User = User.user
                        )

                        return newTarefa as Tarefas
                }
        }

}