package br.com.fiap.mba3scjo2021_grupoa_listou

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET( "/listas/")
    fun getListas(@Path("lista") lista: ListaCompra) : Call<List<ListaCompra>>

    @GET( "/lista/?id={id}")
    fun getLista(@Path("lista") lista: ListaCompra) : Call<ListaCompra>

    @GET("/item/?id={id}")
    fun getItemCompra(@Path("item") item: ItemCompra) : Call<ItemCompra>
}
