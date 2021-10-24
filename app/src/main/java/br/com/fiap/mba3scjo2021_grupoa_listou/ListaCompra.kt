package br.com.fiap.mba3scjo2021_grupoa_listou

import androidx.annotation.StringRes
import com.google.gson.annotations.SerializedName

data class ListaCompra (


    @SerializedName("id") val id: Int,
    @SerializedName("descricao") val descricao: String,
    @SerializedName("isRecorrente") val isRecorrente: Boolean,
    @SerializedName("recorrencia") val recorrencia: String,
    @SerializedName("orcamento") val orcamento: String

)