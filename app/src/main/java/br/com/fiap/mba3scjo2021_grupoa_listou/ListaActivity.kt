package br.com.fiap.mba3scjo2021_grupoa_listou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)


        var listaData = intent
        var listaDescricao = listaData.getStringExtra("descricao")
        var listaDtCompra = listaData.getStringExtra("dtCompra")
        var listaIsRecorrente = listaData.getStringExtra("isRecorrente")
        var listaRecorrencia = listaData.getStringExtra("recorrencia")
        var listaOrcamento = listaData.getStringExtra("orcamento")
        descricao.text = listaDescricao
        dtCompra.text = listaDtCompra
        recorrente.text = listaIsRecorrente
        recorrencia.text = listaRecorrencia
        orcamento.text = listaOrcamento

        val actionBar = supportActionBar
        actionBar!!.title = listaDescricao
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}