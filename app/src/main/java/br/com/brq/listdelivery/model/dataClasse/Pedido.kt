package br.com.brq.listDelivery.model.dataClasse

data class Pedido (
        var nomeDoProduto : String,
        var descricaoDoProduto : String,
        var destinatario : String,
        var enderecoEntrega : String,
        var cpdDoDestinatario : String
)