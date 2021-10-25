package br.com.fiap.mba3scjo2021_grupoa_listou.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListaCompra (


    @SerializedName("id") val id: Int,
    @SerializedName("descricao") val descricao: String,
    @SerializedName("isRecorrente") val isRecorrente: Boolean,
    @SerializedName("recorrencia") val recorrencia: String,
    @SerializedName("orcamento") val orcamento: String

): Parcelable{
    constructor() : this( 0, "",false, "", "")
}