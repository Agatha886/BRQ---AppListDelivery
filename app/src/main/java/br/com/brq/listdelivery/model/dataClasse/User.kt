package br.com.brq.listDelivery.model.dataClasse

import java.io.Serializable

data class User (
    var email : String,
    var senha: String,
    var nome : String,
    var cpf: String
) : Serializable{
    companion object {
        val listaUser = ArrayList<User>()
        lateinit var user : User
    }
}

