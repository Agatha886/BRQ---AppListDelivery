package br.com.brq.listDelivery.model

class Conta (
    var id : Int,
    var email : String,
    var senha : String
){
    var contaUser = listOf<String>("agathamonfredini@gmail.com","alexalves@gmail.com","mariajoaquina@gmail.com")
    fun validConta (): Boolean{
        return false
    }
}