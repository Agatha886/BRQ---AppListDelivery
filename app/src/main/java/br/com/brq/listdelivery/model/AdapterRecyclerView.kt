package br.com.brq.listDelivery.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listDelivery.R
import br.com.brq.listDelivery.model.dataClasse.Tarefas

class AdapterRecyclerView(val context: Context, val listaTarefas: ArrayList<Tarefas>): RecyclerView.Adapter<ViewHoldertarefas>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldertarefas {
        val inflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.item_lista,parent,false)
        return ViewHoldertarefas(view)
    }

    override fun onBindViewHolder(holder: ViewHoldertarefas, position: Int) {
        listaTarefas.get(position).also {
                holder.textViewStatus.text = it?.status.toString()
                holder.textViewData.text = it?.dataDeEntrega
                holder.textViewNomeProduto.text = "Produto: ${it?.pedido?.nomeDoProduto}"
                holder.textViewNomeCliente.text = "Nome: ${it?.pedido?.destinatario}"
                holder.textViewCpfCliente.text = "CPF: ${it?.pedido?.cpfDoDestinatario}"
                holder.imgTarefa.setImageResource(imgListaTarefa(holder))
        }
    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }

    fun addItemLista(tarefa : Tarefas){
        listaTarefas.add(tarefa)
        notifyDataSetChanged()
    }

}

class ViewHoldertarefas(itemView: View): RecyclerView.ViewHolder(itemView){
    var textViewStatus : TextView
    var textViewData : TextView
    var textViewNomeProduto : TextView
    var textViewNomeCliente : TextView
    var textViewCpfCliente : TextView
    var imgTarefa : ImageView
    init {
        textViewStatus = itemView.findViewById(R.id.textStatus)
        textViewData = itemView.findViewById(R.id.textData)
        textViewNomeProduto = itemView.findViewById(R.id.textNomeProduto)
        textViewNomeCliente = itemView.findViewById(R.id.textNomeCliente)
        textViewCpfCliente = itemView.findViewById(R.id.textCpfCliente)
        imgTarefa = itemView.findViewById(R.id.imageTarefa)
    }

}

fun imgListaTarefa(holder: ViewHoldertarefas): Int {
    var img : Int
    if(holder.textViewStatus.text == StatusPedido.PENDENTE.toString()){
        img = R.drawable.tarefa_pendente
    }else if(holder.textViewStatus.text == StatusPedido.ENTREGUE.toString()) {
        img = R.drawable.tarefa_entregue
    }else if(holder.textViewStatus.text == StatusPedido.ATRASADO.toString()){
        img = R.drawable.tarefa_atrasada
    }else{
        img = R.drawable.tarefa_cancelada
    }
    return img
}

//interface ItemClickListener {
//
//    fun onClickItem(view: View?, index: Int)
//    fun onLongClickItem(view: View?, index: Int)
//
//}