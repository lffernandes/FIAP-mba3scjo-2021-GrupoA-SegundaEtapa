package br.com.fiap.mba3scjo2021_grupoa_listou.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ListaCompra{
    constructor(
        id: Int?,
        descricao: String?,
        dtCompra: String?,
        recorrente: String?,
        recorrencia: String?,
        orcamento: String?,
        itens: List<Item>?
    ) {
        this.id = id
        this.descricao = descricao
        this.dtCompra = dtCompra
        this.recorrente = recorrente
        this.recorrencia = recorrencia
        this.orcamento = orcamento
        this.itens = itens
    }

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("descricao")
    @Expose
    var descricao: String? = null

    @SerializedName("dtCompra")
    @Expose
    var dtCompra: String? = null

    @SerializedName("recorrente")
    @Expose
    var recorrente: String? = null

    @SerializedName("recorrencia")
    @Expose
    var recorrencia: String? = null

    @SerializedName("orcamento")
    @Expose
    var orcamento: String? = null

    @SerializedName("itens")
    @Expose
    var itens: List<Item>? = null

}