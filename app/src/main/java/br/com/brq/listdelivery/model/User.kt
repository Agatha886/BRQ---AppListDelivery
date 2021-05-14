package br.com.brq.listdelivery.model

import java.io.Serializable

data class User (
    var email : String,
    var senha: String,
    var nome : String,
) : Serializable {
    companion object {
        val listaUser = hashMapOf<Int,User>()
        lateinit var user : User
    }
}