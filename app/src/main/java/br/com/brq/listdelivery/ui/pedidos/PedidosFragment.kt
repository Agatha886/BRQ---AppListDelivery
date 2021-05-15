package br.com.brq.listdelivery.ui.pedidos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.listDelivery.model.AdapterRecyclerView
import br.com.brq.listdelivery.R
import br.com.brq.listdelivery.model.Tarefas

class PedidosFragment : Fragment() {

    private lateinit var pedidosViewModel : PedidosViewModel
    var listaTarefas = Tarefas.listasTarefas
    var recyclerView: RecyclerView? = null
    var adapter: AdapterRecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        AdapterRecyclerView(context, listaTarefas).let {
            adapter = it
            recyclerView?.adapter = it
        }

        recyclerView?.layoutManager = LinearLayoutManager(this)





        pedidosViewModel = ViewModelProvider(this).get(PedidosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pedidos, container, false)
        val textView: TextView = root.findViewById(R.id.pedidos_fragment)
        pedidosViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root

    }
}