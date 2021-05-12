package br.com.brq.listDelivery

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.brq.listDelivery.model.Conta
import br.com.brq.listDelivery.model.dataClasse.User
import br.com.brq.listDelivery.ui.CriarContaActivity
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
            var conta = Conta()
            var email = editTextEmail.text.toString()
            var senha = editTextSenha.text.toString()

            for ((key, value) in User.listaUses) {
                if (email == value.email && senha == value.senha) {
                val intentTelaPrincipal = Intent(this, PrincipalActivity::class.java)
                 startActivity(intentTelaPrincipal)
                }else{
                    Snackbar.make(
                        findViewById(R.id.ConstraintLayout),
                        R.string.erroLogin,
                        Snackbar.LENGTH_SHORT
                ).setTextColor(Color.RED)
                 .setBackgroundTint(Color.WHITE)
                 .show()
                }
            }
        }
    }

    fun carregarListas(){
        User.listaUses.put(1,User("agathamonfredini@gmail.com","123","Agatha Monfredini","14788965523"))
        User.listaUses.put(2,User("alexalves@gmail.com","123","Alex Alves","78955632258"))
        User.listaUses.put(3,User("mariajoaquina@gmail.com","Maria@741", "Maria Joaquina","78955423365"))
    }


}