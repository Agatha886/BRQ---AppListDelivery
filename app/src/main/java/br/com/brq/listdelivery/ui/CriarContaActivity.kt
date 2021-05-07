package br.com.brq.listdelivery.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.brq.listdelivery.LoginActivity
import br.com.brq.listdelivery.R

class CriarContaActivity : AppCompatActivity() {

    lateinit var textLogar: TextView
    lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta)

        carregarElementos()
        carregarEventos()
    }
    fun carregarElementos() {
        textLogar= findViewById<EditText>(R.id.textJáTem)
        btnLogin = findViewById<Button>(R.id.button_criar_conta)
    }

    fun carregarEventos() {
        textLogar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            val intent = Intent( this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}