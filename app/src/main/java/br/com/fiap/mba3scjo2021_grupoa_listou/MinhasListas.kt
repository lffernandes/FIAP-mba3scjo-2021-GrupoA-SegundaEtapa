package br.com.fiap.mba3scjo2021_grupoa_listou

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DividerItemDecoration
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

class MinhasListas() : AppCompatActivity(), ListasAdapter.ListaClickListener {

    var listasData: ArrayList<ListaCompra> = ArrayList()

    override fun getLista(position: Int) {
        val alertDialog = AlertDialog.Builder(this@MinhasListas)
        alertDialog.setTitle(listasData.get(position).descricao)
        alertDialog.setMessage(listasData.get(position).dtCompra)
        alertDialog.setPositiveButton("OK") { dialog, which ->
            Toast.makeText(this@MinhasListas, "OK", Toast.LENGTH_SHORT).show()
        }
//        alertDialog.setNegativeButton("No") { dialog, which ->
//            Toast.makeText(this@MainActivity, "No", Toast.LENGTH_SHORT).show()
//        }
        alertDialog.show()
    }


    private var myService: RetrofitService? = null
    private var myAdapter: ListasAdapter? = null
    private var myListas: MutableList<ListaCompra> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minhas_listas)

        var recyclerView: RecyclerView = findViewById(R.id.rv_compra_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = ListasAdapter(listMinhasListas(listasData), this@MinhasListas)


    }

}

suspend fun getListas(user: String): LiveData<ArrayList<ListaCompra>> {

    lateinit var liveData: MutableLiveData<ArrayList<ListaCompra>>
    var call = ApiFactory.buildService(RetrofitService::class.java)
    call?.getListas(user)?.enqueue(object : Callback<ArrayList<ListaCompra>> {
        override fun onResponse(
            call: Call<ArrayList<ListaCompra>>,
            response: Response<ArrayList<ListaCompra>>
        ) {
            liveData.value = response.body()
        }

        override fun onFailure(call: Call<ArrayList<ListaCompra>>, t: Throwable) {
        }
    })
    return liveData

}

fun listMinhasListas(myListas: ArrayList<ListaCompra>): ArrayList<ListaCompra> {
    myListas.add(ListaCompra(1, "Lista 1", "23/10/2021", "true", "semmanal", "R$200", null))
    myListas.add(ListaCompra(2, "Lista 2", "30/10/2021", "true", "semmanal", "R$400", null))
    myListas.add(ListaCompra(3, "Lista 3", "6/11/2021", "false", "eventual", "R$600", null))
    myListas.add(ListaCompra(4, "Lista 4", "13/11/2021", "true", "semmanal", "R$800", null))
    return myListas
}
