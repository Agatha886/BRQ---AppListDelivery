package br.com.brq.listdelivery.model.dataClasse

import android.widget.EditText
import androidx.annotation.DrawableRes
import br.com.brq.listdelivery.R
import br.com.brq.listdelivery.model.StatusTarefa
import java.io.Serializable

class Tarefas(
    var status: StatusTarefa,
    var User: User,
    val dataDeEntrega: String,
    val pedido: Pedido,
    val obs: String,
    @DrawableRes
    val photo: Int,

    ):Serializable {
    companion object{
        val BancoDelistasTarefas = ArrayList<Tarefas>()
        var newTarefa : Tarefas? = null

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
                status = StatusTarefa.PENDENTE,
                pedido = pedido,
                dataDeEntrega = editTextData.text.toString() ,
                obs = editTextObs.text.toString(),
                User = User.user,
                photo = R.drawable.tarefa_pendente)

            return newTarefa as Tarefas
        }

    }
}