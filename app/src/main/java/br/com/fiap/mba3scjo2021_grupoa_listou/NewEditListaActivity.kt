package br.com.fiap.mba3scjo2021_grupoa_listou

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import br.com.fiap.mba3scjo2021_grupoa_listou.Services.ApiFactory
import br.com.fiap.mba3scjo2021_grupoa_listou.Services.RetrofitService
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra
import retrofit2.Response

class NewEditListaActivity : AppCompatActivity() {

    private lateinit var retService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_edit_lista)
        retService = ApiFactory
            .getInstance()
            .create(RetrofitService::class.java)
        uploadLista()
    }

    private fun uploadLista() {

        var listaData = intent
        var listaDescricao = listaData.getStringExtra("descricao")
        var listaDtCompra = listaData.getStringExtra("dtCompra")
        var listaIsRecorrente = listaData.getStringExtra("isRecorrente")
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
}