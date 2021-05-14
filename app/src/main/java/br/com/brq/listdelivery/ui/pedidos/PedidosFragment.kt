package br.com.brq.listdelivery.ui.pedidos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.brq.listdelivery.R

class PedidosFragment : Fragment() {

    private lateinit var pedidosViewModel : PedidosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pedidosViewModel = ViewModelProvider(this).get(PedidosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pedidos, container, false)
        val textView: TextView = root.findViewById(R.id.pedidos_fragment)
        pedidosViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root

    }
}