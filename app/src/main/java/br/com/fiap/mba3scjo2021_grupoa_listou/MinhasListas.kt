package br.com.fiap.mba3scjo2021_grupoa_listou

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.mba3scjo2021_grupoa_listou.Adapter.ListasAdapter
import br.com.fiap.mba3scjo2021_grupoa_listou.models.Item
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra
import kotlinx.android.synthetic.main.activity_minhas_listas.*

class MinhasListas : AppCompatActivity() {

    private lateinit var listasAdapter: ListasAdapter
    private lateinit var myListas: ArrayList<ListaCompra>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minhas_listas)

        myListas = ArrayList<ListaCompra>()
        listasAdapter = ListasAdapter(this, myListas)
        rv_compra_list.layoutManager = LinearLayoutManager(this)
        rv_compra_list.adapter = listasAdapter
        listMinhasListas()

        val actionBar = supportActionBar
        actionBar!!.title = "Minhas Listas"
        actionBar.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener {
            val intent = Intent(this, NewEditListaActivity::class.java)
            startActivity(intent);
        }

    }

    fun listMinhasListas() {
        myListas.add(ListaCompra(1, "Lista 1", "23/10/2021", "true", "semmanal", "R$200",null))
        myListas.add(ListaCompra(2, "Lista 2", "30/10/2021", "true", "semmanal", "R$400", null))
        myListas.add(ListaCompra(3, "Lista 3", "6/11/2021", "false", "eventual", "R$600", null))
        myListas.add(ListaCompra(4, "Lista 4", "13/11/2021", "true", "semmanal", "R$800", null))
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

}
