package br.com.fiap.mba3scjo2021_grupoa_listou

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import br.com.fiap.mba3scjo2021_grupoa_listou.Services.RetrofitService
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra
import retrofit2.Response

class NewEditListaActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{

    private lateinit var retService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_edit_lista)

        /* retService = ApiFactory.buildService(RetrofitService::class.java)
        uploadLista()*/

        val spinner: Spinner = findViewById(R.id.periodo_spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(this, R.array.periodo_array, android.R.layout.simple_spinner_item).also {
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

    }


    private fun uploadLista() {

        var listaData = intent
        var listaDescricao = listaData.getStringExtra("descricao")
        var listaDtCompra = listaData.getStringExtra("dtCompra")
        var listaIsRecorrente = listaData.getBooleanExtra("isRecorrente",false)
        var listaRecorrencia = listaData.getStringExtra("recorrencia")
        var listaOrcamento = listaData.getStringExtra("orcamento")


        val lista = ListaCompra(0,
            listaDescricao,
            listaDtCompra,
            listaIsRecorrente,
            listaRecorrencia,
            listaOrcamento,
            null)
        val postResponse: LiveData<Response<ListaCompra>> = liveData {
            val response = retService.uploadLista(lista)
            emit(response)
        }
       /* postResponse.observe(this, Observer {
            val receivedListaItem = it.body()
            val result = " " + "Descricao  : ${receivedListaItem?.descricao}" + "\n" +
                    " " + "Data da Compra: ${receivedListaItem?.dtCompra}" + "\n" +
                    " " + "Recorrente: ${receivedListaItem?.isRecorrente}" + "\n" +
                    " " + "Recorrencia: ${receivedListaItem?.recorrencia}" + "\n" +
                    " " + "Orcamento: ${receivedListaItem?.orcamento}" + "\n\n\n"
        })*/
    }
    //funções para trabalhar com o dropdown(spinner)
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        val spinner: Spinner = findViewById(R.id.periodo_spinner)
        spinner.onItemSelectedListener = this
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}