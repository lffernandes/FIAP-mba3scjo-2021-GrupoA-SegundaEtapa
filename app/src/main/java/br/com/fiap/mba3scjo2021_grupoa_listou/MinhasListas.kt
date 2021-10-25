package br.com.fiap.mba3scjo2021_grupoa_listou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.mba3scjo2021_grupoa_listou.Adapter.ListasAdapter
import br.com.fiap.mba3scjo2021_grupoa_listou.Services.RetrofitFactory
import br.com.fiap.mba3scjo2021_grupoa_listou.Services.RetrofitService
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListasResponse
import kotlinx.android.synthetic.main.activity_minhas_listas.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MinhasListas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minhas_listas)

        rv_compra_list.layoutManager = LinearLayoutManager(this)
        rv_compra_list.setHasFixedSize(true)
        getListaData { listas : List<ListaCompra> ->
            rv_compra_list.adapter = ListasAdapter(listas)
        }
    }

    private fun getListaData(callback: (List<ListaCompra>) -> Unit) {
        val apiService = RetrofitFactory.getInstance().create(RetrofitService::class.java)

        apiService.getListas().enqueue(object : Callback<ListasResponse> {
            override fun onResponse(
                call: Call<ListasResponse>,
                response: Response<ListasResponse>,
            ) {
                return callback(response.body()!!.listas)
            }

            override fun onFailure(call: Call<ListasResponse>, t: Throwable) {

            }
        })
    }
}