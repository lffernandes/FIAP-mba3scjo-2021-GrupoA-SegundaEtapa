package br.com.fiap.mba3scjo2021_grupoa_listou.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListasResponse(
    @SerializedName("results")
    val listas: List<ListaCompra>
) : Parcelable {
    constructor() : this(mutableListOf())
}