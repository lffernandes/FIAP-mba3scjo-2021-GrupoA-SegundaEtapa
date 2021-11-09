package br.com.fiap.mba3scjo2021_grupoa_listou.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ItemCompra : Serializable {
    constructor(id: Int, nome: String?, quantidade: Int?, precoPretendidoUnitario: String?) {
        this.id = id
        this.nome = nome
        this.quantidade = quantidade
        this.precoPretendidoUnitario = precoPretendidoUnitario
    }

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("nome")
    @Expose
    var nome: String? = null

    @SerializedName("quantidade")
    @Expose
    var quantidade: Int?  = null

    @SerializedName("preco_pretendido_unitario")
    @Expose
    var precoPretendidoUnitario: String?  = null
    }
