package br.com.brq.listDelivery

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.brq.listDelivery.model.Conta
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
        carregarEventos()

    }

    fun carregarElementos() {
        btnLogin = findViewById<Button>(R.id.button_login)
        btnCriar = findViewById<Button>(R.id.button_criar)
        editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        editTextSenha = findViewById<EditText>(R.id.editTextSenha)
    }

    fun carregarEventos() {
        btnLogin.setOnClickListener {
            var conta = Conta()
            var email = editTextEmail.text.toString()
            var senha = editTextSenha.text.toString()
            var valid = conta.validAcesso(editTextEmail = email, editTextSenha = senha)
            if(valid){
                val intentTelaPrincipal = Intent(this, PrincipalActivity::class.java)
                startActivity(intentTelaPrincipal)
            }else{
//                Snackbar.make(
//                        findViewById(R.id.ConstraintLayout),
//                        R.string.erroLogin,
//                        Snackbar.LENGTH_SHORT
//                ).show()
                Snackbar.make(
                        findViewById(R.id.ConstraintLayout),
                        R.string.erroLogin,
                        Snackbar.LENGTH_SHORT
                ).setTextColor(Color.RED)
                 .setBackgroundTint(Color.WHITE)
                 .show()
            }
        }
        btnCriar.setOnClickListener {
            val intentTelaDeCadastro = Intent(this, CriarContaActivity::class.java)
            startActivity(intentTelaDeCadastro)
        }
    }


}