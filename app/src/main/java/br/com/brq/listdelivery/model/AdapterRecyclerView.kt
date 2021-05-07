package br.com.brq.listDelivery.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listDelivery.R
import br.com.brq.listDelivery.model.dataClasse.Tarefas

class AdapterRecyclerView(val context : Context , val listaTarefas: ArrayList<Tarefas>): RecyclerView.Adapter<ViewHoldertarefas>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldertarefas {
        val inflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.item_lista,parent,false)
        return ViewHoldertarefas(view)
    }

    override fun onBindViewHolder(holder: ViewHoldertarefas, position: Int) {

        listaTarefas.get(position).also {
            holder.textViewStatus.text = it.status.toString()
            holder.textViewData.text = it.dataDeEntrega
            holder.textViewObs.text = it.pedido.nomeDoProduto
        }
         listaTarefas[position].toString()
    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }
}

class ViewHoldertarefas(itemView: View): RecyclerView.ViewHolder(itemView){
    var textViewStatus : TextView
    var textViewData : TextView
    var textViewObs : TextView
    init {
        textViewStatus = itemView.findViewById(R.id.textStatus)
        textViewData = itemView.findViewById(R.id.textData)
        textViewObs = itemView.findViewById(R.id.textObd)
    }
}