package br.com.brq.listdelivery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.brq.listdelivery.R

class PrincipalActivity : AppCompatActivity() {
    lateinit var btnPrincipal: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)


    }
}