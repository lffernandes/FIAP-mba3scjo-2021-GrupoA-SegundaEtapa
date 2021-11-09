package br.com.fiap.mba3scjo2021_grupoa_listou

import android.content.ClipData
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.mba3scjo2021_grupoa_listou.Adapter.ListaAdapter
import br.com.fiap.mba3scjo2021_grupoa_listou.Adapter.ListasAdapter
import br.com.fiap.mba3scjo2021_grupoa_listou.databinding.ActivityListaBinding
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ItemCompra
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_lista.view.*

class ListaActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_lista)


       /* val mlista: ItemCompra = intent.getSerializableExtra("itens") as ItemCompra*/
        val json = intent.getStringExtra("itens");
        val gson = Gson()
        val itemType = object : TypeToken<ArrayList<ItemCompra>>() {}.type
        val myItens = gson.fromJson<ArrayList<ItemCompra>>(json, itemType)


        var id = findViewById<TextView>(R.id.id)
        id.text = intent.getStringExtra("id")

        var descricao = findViewById<TextView>(R.id.descricao)
        descricao.text = intent.getStringExtra("descricao")

        var dtCompra = findViewById<TextView>(R.id.dtCompra)
        dtCompra.text = intent.getStringExtra("dtCompra")

        var recorrente = findViewById<TextView>(R.id.recorrente)
        recorrente.text = intent.getStringExtra("recorrente")

        var recorrencia = findViewById<TextView>(R.id.recorrencia)
        recorrencia.text = intent.getStringExtra("recorrencia")

        var orcamento = findViewById<TextView>(R.id.orcamento)
        orcamento.text = intent.getStringExtra("orcamento")

        var recyclerView: RecyclerView = findViewById(R.id.rv_item_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))


        recyclerView.addItemDecoration(DividerItemDecoration(this, 0))
        recyclerView.adapter = ListaAdapter(myItens)
    }
}