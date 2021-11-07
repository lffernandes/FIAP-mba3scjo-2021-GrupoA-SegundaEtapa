package br.com.fiap.mba3scjo2021_grupoa_listou

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.mba3scjo2021_grupoa_listou.Adapter.ListasAdapter
import br.com.fiap.mba3scjo2021_grupoa_listou.Services.ApiFactory
import br.com.fiap.mba3scjo2021_grupoa_listou.Services.RetrofitService
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra
import kotlinx.android.synthetic.main.activity_minhas_listas.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MinhasListas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minhas_listas)

        val actionBar = supportActionBar
        actionBar!!.title = "Minhas Listas"
        actionBar.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener {
            val intent = Intent(this, NewEditListaActivity::class.java)
            startActivity(intent);
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_compra_list)
        val request = ApiFactory.buildService(RetrofitService::class.java)
        val call = request?.getListas()


        call?.enqueue(object : Callback<List<ListaCompra>> {
            override fun onResponse(
                call: Call<List<ListaCompra>>,
                response: Response<List<ListaCompra>>
            ) {
                if (response.isSuccessful) {
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@MinhasListas)
                        adapter = ListasAdapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<List<ListaCompra>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
/*
        val recyclerView = findViewById<RecyclerView>(R.id.rv_compra_list)

        val serviceGenerator = ApiFactory.buildService(RetrofitService::class.java)
        val call = serviceGenerator?.getListas()

        call?.enqueue(object : Callback<MutableList<ListaCompra>>{

            override fun onResponse(call: Call<MutableList<ListaCompra>>, response: Response<MutableList<ListaCompra>>){
                if(response.isSuccessful){
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@MinhasListas)
                        adapter = ListasAdapter(response.body()!!)
                    }
                }*/


/*
            override fun onFailure(call: Call<MutableList<ListaCompra>>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }
        })
    }

    private fun showError() {
        Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_SHORT).show()
    }
}

private fun <T> Call<T>?.enqueue(callback: Callback<MutableList<ListaCompra>>) {*/


