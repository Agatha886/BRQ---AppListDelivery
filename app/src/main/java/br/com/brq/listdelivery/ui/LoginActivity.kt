package br.com.brq.listdelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.brq.listdelivery.model.User
import br.com.brq.listdelivery.ui.CriarContaActivity
import br.com.brq.listdelivery.ui.PrincipalActivity

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var btnCriar: Button
    lateinit var editTextEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        println("----- ON CREATE")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        carregarElementos()
        carregarEventos()

        val email = editTextEmail.text.toString()
        val user = User(nome = "Agatha", email = email, senha = "123", idade = 20)
        if (user.validarEmail()) {
            println("Email TRUE")
        } else {
            println("Email FALSE")
        }
        user.addIdade(novaIdade = 5)
        println(user.idade)
    }

    fun carregarElementos() {
        btnLogin = findViewById<Button>(R.id.button_login)
        btnCriar = findViewById<Button>(R.id.button_criar)
        editTextEmail = findViewById<EditText>(R.id.editTextEmail)
    }

    fun carregarEventos() {
        btnLogin.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }
        btnCriar.setOnClickListener {
            val intent = Intent(this, CriarContaActivity::class.java)
            startActivity(intent)
        }
    }


}