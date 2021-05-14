package br.com.brq.listdelivery

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

    override fun onCreate(savedInstanceState: Bundle?) {
        println("----- ON CREATE")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        carregarElementos()
        carregarListas()
        carregarEventos()
        carregareAdicionarExtrasNovaConta()



    }

    fun carregarElementos() {
        btnLogin = findViewById<Button>(R.id.button_login)
        btnCriar = findViewById<Button>(R.id.button_criar)
        editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        editTextSenha = findViewById<EditText>(R.id.editTextSenha)
    }

    fun carregarEventos() {
        btnLogin.setOnClickListener {
            var email = editTextEmail.text.toString()
            var senha = editTextSenha.text.toString()

            for ((key, value) in User.listaUser) {
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

    fun carregarListas(){
        User.listaUser.put(1,User("agathamonfredini@gmail.com","123","Agatha Monfredini"))
        User.listaUser.put(2,User("alexalves@gmail.com","123","Alex Alves"))
        User.listaUser.put(3,User("mariajoaquina@gmail.com","Maria@741", "Maria Joaquina"))
    }

    fun carregareAdicionarExtrasNovaConta(){

        novoUsuarioNome = intent.getStringExtra("nome").toString()
        novoUsuarioSenha = intent.getStringExtra("senha").toString()
        novoUsuarioEmail = intent.getStringExtra("email").toString()

        if(
            !novoUsuarioEmail.isNullOrBlank() &&
            !novoUsuarioNome.isNullOrBlank() &&
            !novoUsuarioSenha.isNullOrBlank()
        ){
            println("email = ${novoUsuarioEmail} nome = ${novoUsuarioNome} senha = ${novoUsuarioSenha} ")

            User.listaUser.put(
                User.listaUser.size+1,
                User(novoUsuarioEmail,novoUsuarioSenha,novoUsuarioNome)
            )
        }

    }

}