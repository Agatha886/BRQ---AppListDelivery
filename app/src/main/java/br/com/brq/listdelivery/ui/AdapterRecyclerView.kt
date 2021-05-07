package com.mobway.minhaprimeiralista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRecyclerView(
    val context: Context,
    val nossaListaDeAnimais: ArrayList<String>

) : RecyclerView.Adapter<ViewHolderAnimais>() {

    /**
     * Passa neste método para definir qual o laysout que vc quer usar em cada item da lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAnimais {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.item_da_nossa_lista, parent, false)
        return ViewHolderAnimais(view)
    }

    /**
     * Passa neste método para popular cada item da lista
     */
    override fun onBindViewHolder(holder: ViewHolderAnimais, position: Int) {
        holder.textViewTitulo.text = "$position - ${nossaListaDeAnimais[position]}"
    }

    /**
     * Verifica o número de elementos no array
     * Usa este método como base para carregar a sua lista (Para o adapter saber o total de elementos que vai utilizar)
     */
    override fun getItemCount(): Int {
        return nossaListaDeAnimais.size
    }
}

/**
 * View onde serão manipulados os elementos da tela com o Kotlin
 */
class ViewHolderAnimais(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var textViewTitulo : TextView

    init {
        textViewTitulo = itemView.findViewById(R.id.textView_titulo)
    }

}