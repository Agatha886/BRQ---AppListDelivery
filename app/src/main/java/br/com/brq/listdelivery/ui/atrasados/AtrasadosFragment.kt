package br.com.brq.listdelivery.ui.atrasados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.brq.listdelivery.R

class AtrasadosFragment : Fragment() {

    private lateinit var atrasadosViewModel : AtrasadosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        atrasadosViewModel = ViewModelProvider(this).get(AtrasadosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_atrasados, container, false)
        val textView: TextView = root.findViewById(R.id.atrasados_fragment)
        atrasadosViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}