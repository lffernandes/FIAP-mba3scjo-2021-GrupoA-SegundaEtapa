package br.com.fiap.mba3scjo2021_grupoa_listou

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.mba3scjo2021_grupoa_listou.Adapter.ListaAdapter
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ItemCompra
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra

class ListaActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)


        val mlista: ListaCompra = intent.getSerializableExtra("lista") as ListaCompra
        val listaId: String = intent.getStringExtra("id") as String
        val listaDescricao: String = intent.getStringExtra("descricao") as String
        val listaDtCompra: String = intent.getStringExtra("dtCompra") as String
        val listaRecorrente: String = intent.getStringExtra("recorrente") as String
        val listaRecorrencia: String = intent.getStringExtra("recorrencia") as String
        val listaOrcamento: String = intent.getStringExtra("orcamento") as String

        findViewById<TextView>(R.id.id).apply{
            text = listaId
        }
        findViewById<TextView>(R.id.descricao).apply{
            text = listaDescricao
        }

        findViewById<TextView>(R.id.dtCompra).apply{
            text = listaDtCompra
        }
        findViewById<TextView>(R.id.recorrente).apply{
            text = listaRecorrente
        }
        findViewById<TextView>(R.id.recorrencia).apply{
            text = listaRecorrencia
        }
        findViewById<TextView>(R.id.orcamento).apply{
            text = listaOrcamento
        }

/*
        var recyclerView: RecyclerView = findViewById(R.id.rv_item_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = ListaAdapter(mlista.itens as ArrayList<ItemCompra>)*/

        /*      val actionBar = supportActionBar
              actionBar!!.title = "Minhas Listas"
              actionBar.setDisplayHomeAsUpEnabled(true)

              val actionBar = supportActionBar
              actionBar!!.title = mlista.descricao
              actionBar.setDisplayHomeAsUpEnabled(true)*/
    }

}