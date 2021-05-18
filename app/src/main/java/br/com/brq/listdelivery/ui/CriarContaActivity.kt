package br.com.brq.listdelivery.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.brq.listdelivery.LoginActivity
import br.com.brq.listdelivery.R
import com.google.android.material.snackbar.Snackbar

class CriarContaActivity : AppCompatActivity() {

    lateinit var textVoltarLogin: TextView
    lateinit var btnCriarConta : Button
    lateinit var editTextSenha : EditText
    lateinit var editTextConfirmarSenha : EditText
    lateinit var editTextEmail : EditText
    lateinit var editTextNome : EditText
    lateinit var editTextCpf : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta)

        carregarElementos()
        carregarEventos()

    }
    fun carregarElementos() {
        textVoltarLogin= findViewById<EditText>(R.id.textJáTem)
        btnCriarConta = findViewById<Button>(R.id.button_criar_conta)
        editTextNome = findViewById<EditText>(R.id.editTextNome)
        editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        editTextSenha = findViewById<EditText>(R.id.editTextSenha)
        editTextConfirmarSenha = findViewById<EditText>(R.id.editTextConfirmarSenha)
        editTextCpf = findViewById(R.id.editTextCpfCliente)
    }

    fun carregarEventos() {
        textVoltarLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnCriarConta.setOnClickListener{

            val confirmarSenha = editTextConfirmarSenha.text.toString()
            val email = editTextEmail.text.toString()
            val nome = editTextNome.text.toString()
            val senha = editTextSenha.text.toString()
            val cpf = editTextCpf.text.toString()

            if(validarNovoUser(nome,email,senha,confirmarSenha)){
                val intent = Intent(this, LoginActivity::class.java)

                intent.putExtra("senha",senha)
                intent.putExtra("email", email)
                intent.putExtra("nome", nome)
                intent.putExtra("cpf",cpf)

                startActivity(intent)

            } else {
                println("Alguma informação está incorreta!")
                Snackbar.make(findViewById(R.id.CriarContaLayout),"Alguma informação está incorreta!",
                    Snackbar.LENGTH_SHORT
                ).setTextColor(Color.BLACK)
                    .setBackgroundTint(getResources().getColor(R.color.color_cancelada))
                    .setTextColor(Color.WHITE)
                    .show()
            }

        }

    }

    fun validarNovoUser(nome:String,email:String,senha:String,confirmarSenha:String):Boolean {
        return !(nome.isNullOrBlank() && senha.isNullOrBlank() &&
                email.isNullOrBlank() && confirmarSenha.isNullOrBlank()) && senha == confirmarSenha
    }

}