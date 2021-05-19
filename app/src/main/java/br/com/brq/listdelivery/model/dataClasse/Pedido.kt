package br.com.brq.listdelivery.model.dataClasse

import java.io.Serializable

data class Pedido (
        var nomeDoProduto : String,
        var descricaoDoProduto : String,
        var destinatario : String,
        var enderecoEntrega : String,
        var cpfDoDestinatario : String,
): Serializable {
    companion object{
        val listasPedido = ArrayList<Pedido>()
    }

}