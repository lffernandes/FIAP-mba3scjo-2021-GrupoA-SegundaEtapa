package br.com.fiap.mba3scjo2021_grupoa_listou.models

import com.google.gson.annotations.SerializedName

data class ItemCompra (
    @SerializedName("id") val id: Int,
    @SerializedName("nome") val nome: String,
    @SerializedName("quantidade") val quantidade: Int,
    @SerializedName("precoPretendidoUnitario") val precoPretendidoUnitario: String
)
