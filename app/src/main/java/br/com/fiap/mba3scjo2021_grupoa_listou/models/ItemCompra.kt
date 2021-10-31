package br.com.fiap.mba3scjo2021_grupoa_listou.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Item (
    @SerializedName("nome")
    @Expose
    var nome: String?,

    @SerializedName("quantidade")
    @Expose
    var quantidade: Int?,

    @SerializedName("preco_pretendido_unitario")
    @Expose
    var precoPretendidoUnitario: String?
) :Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeValue(quantidade)
        parcel.writeString(precoPretendidoUnitario)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }

}