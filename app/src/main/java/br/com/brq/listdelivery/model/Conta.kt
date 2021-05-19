package br.com.brq.listDelivery.model

import br.com.brq.listDelivery.model.dataClasse.User

class Conta (){
    var contaUser = listOf<String>("agathamonfredini@gmail.com","alexalves@gmail.com","mariajoaquina@gmail.com")
    var contaSenha = listOf<String>("123","123","Maria@741")
    var retorno : Boolean = false
    fun validAcesso (editTextEmail: String, editTextSenha: String): Boolean{
        var i: Int = 0
        while (i <= contaUser.size) {

            if (contaUser[i]== editTextEmail && contaSenha[i] == editTextSenha) {
                retorno = true
            }
            else{
                break
            }
         i++
        }
        return retorno
    }

}