package br.com.brq.meuprimeiroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.brq.meuprimeiroapp.ui.CriarContaActivity

class PrincipalActivity : AppCompatActivity() {
    lateinit var btnPrincipal: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        carregarElementos()
        carregarEventos()
    }

    fun carregarElementos() {
        btnPrincipal = findViewById<Button>(R.id.button_principal)
    }

    fun carregarEventos() {
        btnPrincipal.setOnClickListener {
            val intent = Intent(this, CriarContaActivity::class.java)
            startActivity(intent)
        }
    }
}