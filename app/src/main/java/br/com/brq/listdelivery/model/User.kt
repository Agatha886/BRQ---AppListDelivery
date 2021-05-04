package br.com.brq.listdelivery.model

class User (var nome: String,
            var email: String,
            var senha: String,
            var idade: Int
            ){
    fun validarEmail() : Boolean{
        return email !=""
    }
    fun addIdade(novaIdade: Int){
        idade = idade + novaIdade;
    }
}