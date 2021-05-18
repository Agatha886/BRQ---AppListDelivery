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

class AdapterRecyclerView(val context: Context, val listaTarefas: ArrayList<Tarefas>,val onClick: ItemClickListener? = null): RecyclerView.Adapter<ViewHoldertarefas>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldertarefas {
        val inflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.item_lista,parent,false)
        return ViewHoldertarefas(view,onClick)
    }

    override fun onBindViewHolder(holder: ViewHoldertarefas, position: Int) {
        listaTarefas.get(position).also {
                holder.textViewStatus.text = it?.status.toString()
                holder.textViewData.text = it?.dataDeEntrega
                holder.textViewNomeProduto.text = "Produto: ${it?.pedido?.nomeDoProduto}"
                holder.textViewNomeCliente.text = "Nome: ${it?.pedido?.destinatario}"
                holder.textViewCpfCliente.text = "CPF: ${it?.pedido?.cpfDoDestinatario}"
                holder.imgTarefa.setImageResource(it.photo)
        }
    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }

    fun addItemLista(tarefa : Tarefas){
        listaTarefas.add(tarefa)
        notifyList()
    }

    fun addLista(listaTarefas: ArrayList<Tarefas>){
        this.listaTarefas.clear()
        this.listaTarefas.addAll(listaTarefas)
        notifyList()
    }

    fun remoteItem(index: Int){
        listaTarefas.removeAt(index)
        notifyList()
    }

    fun updateList(listTarefas: ArrayList<Tarefas>){
        this.listaTarefas.clear()
        this.listaTarefas.addAll(listTarefas)
        notifyList()
    }

    private fun notifyList(){
        notifyDataSetChanged()
    }

}

class ViewHoldertarefas(itemView: View, private val nossaInterface: ItemClickListener?)
    : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener{

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

        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    override fun onClick(v: View?) {
        nossaInterface?.onClickItem(v, adapterPosition)
    }

    override fun onLongClick(v: View?): Boolean {
        nossaInterface?.onLongClickItem(v, adapterPosition)
        return true
    }

}

interface ItemClickListener {

    fun onClickItem(view: View?, index: Int)
    fun onLongClickItem(view: View?, index: Int):Boolean

}
