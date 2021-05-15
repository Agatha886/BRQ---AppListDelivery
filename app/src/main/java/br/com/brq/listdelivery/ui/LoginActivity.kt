package br.com.brq.listdelivery

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.brq.listdelivery.model.CarregarListas
import br.com.brq.listdelivery.model.Tarefas
import br.com.brq.listdelivery.model.User
import br.com.brq.listdelivery.ui.CriarContaActivity
import br.com.brq.listdelivery.ui.PrincipalActivity
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var btnCriar: Button
    lateinit var editTextEmail: EditText
    lateinit var editTextSenha : EditText
    lateinit var novoUsuarioNome : String
    lateinit var novoUsuarioEmail : String
    lateinit var novoUsuarioSenha : String
    lateinit var novoUsuarioCpf : String
    lateinit var carregarListas : CarregarListas

    override fun onCreate(savedInstanceState: Bundle?) {
        println("----- ON CREATE")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        carregarElementos()

        if(Tarefas.listasTarefas.size == 0){
            carregarListas.carregarListas()
        }

        carregarEventos()
        carregareAdicionarExtrasNovaConta()


    }

    fun carregarElementos() {
        btnLogin = findViewById<Button>(R.id.button_login)
        btnCriar = findViewById<Button>(R.id.button_criar)
        editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        editTextSenha = findViewById<EditText>(R.id.editTextSenha)
        carregarListas = CarregarListas()
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
                        findViewById(R.id.LoginLayout),
                        "Login não encontrado!",
                        Snackbar.LENGTH_SHORT
                    ).setTextColor(Color.RED)
                        .setBackgroundTint(Color.WHITE)
                        .show()
                }
            }
        }

        btnCriar.setOnClickListener{
            val intent = Intent(this, CriarContaActivity::class.java)
            startActivity(intent)
        }
    }

    fun carregareAdicionarExtrasNovaConta(){

        novoUsuarioNome = intent.getStringExtra("nome").toString()
        novoUsuarioSenha = intent.getStringExtra("senha").toString()
        novoUsuarioEmail = intent.getStringExtra("email").toString()
        novoUsuarioCpf = intent.getStringExtra("email").toString()

        if(
            !novoUsuarioEmail.isBlank() &&
            !novoUsuarioNome.isBlank() &&
            !novoUsuarioSenha.isBlank() &&
            !novoUsuarioCpf.isBlank()
        ){
            println("email = ${novoUsuarioEmail} nome = ${novoUsuarioNome} senha = ${novoUsuarioSenha} cpf = ${novoUsuarioCpf} ")

            User.listaUser.add(
                User(novoUsuarioEmail,novoUsuarioSenha,novoUsuarioNome,novoUsuarioCpf)
            )
        }

    }

}