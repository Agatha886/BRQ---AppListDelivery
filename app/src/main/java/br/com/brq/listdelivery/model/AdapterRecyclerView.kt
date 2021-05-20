package br.com.brq.listdelivery.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listdelivery.R
import br.com.brq.listdelivery.model.dataClasse.Tarefas

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


    fun setStatusEntregue(index: Int){
        listaTarefas[index].status = StatusTarefa.ENTREGUE
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
    : RecyclerView.ViewHolder(itemView), View.OnClickListener{

    var textViewStatus : TextView
    var textViewData : TextView
    var textViewNomeProduto : TextView
    var imgTarefa : ImageView
    var buttonDelete : Button

    init {
        textViewStatus = itemView.findViewById(R.id.textStatus)
        textViewData = itemView.findViewById(R.id.textData)
        textViewNomeProduto = itemView.findViewById(R.id.textNomeProduto)
        imgTarefa = itemView.findViewById(R.id.imageTarefa)
        buttonDelete = itemView.findViewById(R.id.deleteButton)

        itemView.setOnClickListener(this)

        buttonDelete.setOnClickListener(){
            nossaInterface?.onClickButtonDelete(it, adapterPosition)
        }

    }

    override fun onClick(v: View?) {
        nossaInterface?.onClickItem(v, adapterPosition)
    }

}

interface ItemClickListener {

    fun onClickButtonDelete(view: View?,index: Int)
    fun onClickItem(view: View?, index: Int)

}
