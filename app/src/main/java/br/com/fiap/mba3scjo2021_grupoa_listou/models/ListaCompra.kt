package br.com.fiap.mba3scjo2021_grupoa_listou.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ListaCompra(
    @SerializedName("id")
    @Expose
    var id: Int?,

    @SerializedName("descricao")
    @Expose
    var descricao: String?,

    @SerializedName("dt_compra")
    @Expose
    var dtCompra: String?,

    @SerializedName("is_recorrente")
    @Expose
    var isRecorrente: String?,

    @SerializedName("recorrencia")
    @Expose
    var recorrencia: String?,

    @SerializedName("orcamento")
    @Expose
    var orcamento: String?,

    @SerializedName("itens")
    @Expose
    var itens: List<Item>?,
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("itens")) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(descricao)
        parcel.writeString(dtCompra)
        parcel.writeString(isRecorrente)
        parcel.writeString(recorrencia)
        parcel.writeString(orcamento)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ListaCompra> {
        override fun createFromParcel(parcel: Parcel): ListaCompra {
            return ListaCompra(parcel)
        }

        override fun newArray(size: Int): Array<ListaCompra?> {
            return arrayOfNulls(size)
        }
    }

}