package br.com.brq.meuprimeiroapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.brq.meuprimeiroapp.LoginActivity
import br.com.brq.meuprimeiroapp.PrincipalActivity
import br.com.brq.meuprimeiroapp.R

class CriarContaActivity : AppCompatActivity() {

    lateinit var textLogar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta)

        carregarElementos()
        carregarEventos()
    }
    fun carregarElementos() {
        textLogar= findViewById<EditText>(R.id.textJáTem)
    }

    fun carregarEventos() {
        textLogar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}