package br.com.brq.listDelivery

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.brq.listDelivery.model.dataClasse.User
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var btnCriar: Button
    lateinit var editTextEmail: EditText
    lateinit var editTextSenha : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        carregarElementos()
        carregarListas()
        carregarEventos()

    }

    fun carregarElementos() {
        btnLogin = findViewById<Button>(R.id.button_login)
        btnCriar = findViewById<Button>(R.id.button_criar)
        editTextEmail = findViewById<EditText>(R.id.editTextDescricao)
        editTextSenha = findViewById<EditText>(R.id.editTextDestintario)
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
                        findViewById(R.id.ConstraintLayout),
                        R.string.erro_cadastro,
                        Snackbar.LENGTH_SHORT
                ).setTextColor(Color.RED)
                 .setBackgroundTint(Color.WHITE)
                 .show()
                }
            }
        }
    }

    fun carregarListas(){
        User.listaUser.put(1,User("agathamonfredini@gmail.com","123","Agatha Monfredini","14788965523"))
        User.listaUser.put(2,User("alexalves@gmail.com","123","Alex Alves","78955632258"))
        User.listaUser.put(3,User("mariajoaquina@gmail.com","Maria@741", "Maria Joaquina","78955423365"))
    }


}