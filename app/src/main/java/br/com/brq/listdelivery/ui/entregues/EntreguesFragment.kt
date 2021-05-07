package br.com.brq.listdelivery.ui.entregues

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.brq.listdelivery.R

class EntreguesFragment : Fragment() {

    private lateinit var entreguesViewModel : EntreguesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        entreguesViewModel = ViewModelProvider(this).get(EntreguesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pedidos, container, false)
        val textView: TextView = root.findViewById(R.id.entregues_fragment)
        entreguesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root

    }
}