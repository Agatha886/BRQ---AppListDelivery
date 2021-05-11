package br.com.brq.listdelivery.ui.cancelados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.brq.listdelivery.R

class CanceladosFragment : Fragment() {

    private lateinit var canceladosViewModel : CanceladosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        canceladosViewModel = ViewModelProvider(this).get(CanceladosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cancelados, container, false)
        val textView: TextView = root.findViewById(R.id.cancelados_fragment)
        canceladosViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root

    }
}