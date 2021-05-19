package br.com.brq.listDelivery.model.dataClasse

import androidx.annotation.DrawableRes
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