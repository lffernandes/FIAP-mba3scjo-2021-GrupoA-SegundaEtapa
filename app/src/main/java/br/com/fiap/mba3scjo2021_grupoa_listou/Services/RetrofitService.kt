package br.com.fiap.mba3scjo2021_grupoa_listou.Services

import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*

public interface RetrofitService {

    @GET("/listas/{user}}")
     suspend fun getListas(@Path ("user") user: String) : Call<ArrayList<ListaCompra>>

    @GET("lista/{listaId}")
    suspend fun getListaById(
        @Path("listaId") ListaId : Int
    ): Response<ListaResponse>

    @POST("/user/lista")
    suspend fun uploadLista (@Body lista:ListaCompra) : Response<ListaCompra>

}
