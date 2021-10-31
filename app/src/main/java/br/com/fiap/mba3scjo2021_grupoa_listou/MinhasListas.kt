package br.com.fiap.mba3scjo2021_grupoa_listou

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.mba3scjo2021_grupoa_listou.Adapter.ListasAdapter
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra
import kotlinx.android.synthetic.main.activity_minhas_listas.*
import br.com.fiap.mba3scjo2021_grupoa_listou.databinding.ItemListasBinding

class MinhasListas : AppCompatActivity() {

    private lateinit var listasAdapter: ListasAdapter
    private lateinit var myListas: ArrayList<ListaCompra>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minhas_listas)

        myListas = ArrayList<ListaCompra>()
        listasAdapter = ListasAdapter(myListas)
        rv_compra_list.layoutManager = LinearLayoutManager(this)
        rv_compra_list.adapter = listasAdapter
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
    }

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

}
