package br.com.brq.listDelivery

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.brq.listDelivery.model.dataClasse.User
import br.com.brq.listDelivery.model.CarregarListas
import br.com.brq.listDelivery.ui.CriarContaActivity
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var btnCriar: Button
    lateinit var editTextEmail: EditText
    lateinit var editTextSenha : EditText
    lateinit var carregarLlistas : CarregarListas

    lateinit var novoUsuarioNome : String
    lateinit var novoUsuarioEmail : String
    lateinit var novoUsuarioSenha : String
    lateinit var novoUsuarioCpf : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        carregarElementos()
        carregarLlistas.carregarListas()
        carregarEventos()
        carregareAdicionarExtrasNovaConta()

    }

    fun carregarElementos() {
        btnLogin = findViewById<Button>(R.id.button_login)
        btnCriar = findViewById<Button>(R.id.button_criar)
        editTextEmail = findViewById<EditText>(R.id.editTextDescricao)
        editTextSenha = findViewById<EditText>(R.id.editTextDestintario)
        carregarLlistas = CarregarListas()
    }

    fun carregarEventos() {
        btnLogin.setOnClickListener {
            var email = editTextEmail.text.toString()
            var senha = editTextSenha.text.toString()

            for (value in User.listaUser) {
                if (email == value.email && senha == value.senha) {
                val intentTelaPrincipal = Intent(this, PrincipalActivity::class.java)
                 startActivity(intentTelaPrincipal)
                   User.user = value
                }else{
                    Snackbar.make(
                        findViewById(R.id.ConstraintLayout),
                        R.string.erro_cadastro,
                        Snackbar.LENGTH_SHORT
                ).setTextColor(Color.RED)
                 .setBackgroundTint(Color.WHITE)
                 .show()
                }
            }
        }

        btnCriar.setOnClickListener {
            val intentTelaCriarConta = Intent(this, CriarContaActivity::class.java)
            startActivity(intentTelaCriarConta)
        }
    }

        fun carregareAdicionarExtrasNovaConta(){

        novoUsuarioNome = intent.getStringExtra("nome").toString()
        novoUsuarioSenha = intent.getStringExtra("senha").toString()
        novoUsuarioEmail = intent.getStringExtra("email").toString()
        novoUsuarioCpf = intent.getStringExtra("cpf").toString()

        if(
            !novoUsuarioEmail.isNullOrBlank() &&
            !novoUsuarioNome.isNullOrBlank() &&
            !novoUsuarioSenha.isNullOrBlank()
        ){
            println("email = ${novoUsuarioEmail} nome = ${novoUsuarioNome} senha = ${novoUsuarioSenha} cpf = ${novoUsuarioCpf}")

            User.listaUser.add(User(novoUsuarioEmail,novoUsuarioSenha,novoUsuarioNome,novoUsuarioCpf))
        }

    }

}