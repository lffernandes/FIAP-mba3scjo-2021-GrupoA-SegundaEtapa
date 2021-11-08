package br.com.fiap.mba3scjo2021_grupoa_listou.models

import com.google.gson.annotations.SerializedName


class ListasResponse{
    @SerializedName("results")
    var listas: List<ListaCompra>? = null
}
