package br.com.brq.listDelivery.model.dataClasse

import android.widget.EditText
import androidx.annotation.DrawableRes
import br.com.brq.listDelivery.R
import br.com.brq.listDelivery.model.StatusPedido
import java.io.Serializable
import kotlin.properties.Delegates

class Tarefas(
    var status: StatusPedido,
    var User: User,
    val dataDeEntrega: String,
    val pedido: Pedido,
    val obs: String,
    @DrawableRes
    val photo: Int,

    ):Serializable {
    companion object{
        val listasTarefas = ArrayList<Tarefas>()
        var newTarefa : Tarefas? = null
        var img by Delegates.notNull<Int>()

        fun NovaTarefa(editTextNomeDoProduto: EditText, editTextDescricao:EditText, editTextDestinatario:EditText, editTextEndereco:EditText, editTextCpfDoCliente:EditText,
                       editTextData:EditText, editTextObs:EditText):Tarefas{
            var pedido = Pedido(
                nomeDoProduto = editTextNomeDoProduto.text.toString(),
                descricaoDoProduto = editTextDescricao.text.toString(),
                destinatario = editTextDestinatario.text.toString(),
                enderecoEntrega = editTextEndereco.text.toString(),
                cpfDoDestinatario = editTextCpfDoCliente.text.toString()
            )

            newTarefa = Tarefas(
                status = StatusPedido.PENDENTE,
                pedido = pedido,
                dataDeEntrega = editTextData.text.toString() ,
                obs = editTextObs.text.toString(),
                User = User.user,
                photo = R.drawable.tarefa_pendente)

            return newTarefa as Tarefas
        }
    }

}