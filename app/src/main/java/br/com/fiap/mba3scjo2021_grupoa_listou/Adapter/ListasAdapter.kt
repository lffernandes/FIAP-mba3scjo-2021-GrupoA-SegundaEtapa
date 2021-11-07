package br.com.fiap.mba3scjo2021_grupoa_listou.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.mba3scjo2021_grupoa_listou.ListaActivity
import br.com.fiap.mba3scjo2021_grupoa_listou.R
import br.com.fiap.mba3scjo2021_grupoa_listou.databinding.ItemListasBinding
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra

class ListasAdapter(val listas: List<ListaCompra>) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_minhas_listas, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        return holder.bind(listas[position])
    }

    override fun getItemCount(): Int {
        return listas.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val nomeLista: TextView = itemView.findViewById(R.id.nomeLista)
    val dtcompra: TextView = itemView.findViewById(R.id.dtCompra)
    val repetirlista: TextView = itemView.findViewById(R.id.repetirLista)
    val periodolista: TextView = itemView.findViewById(R.id.PeriodoLista)
    val ttdisponivel: TextView = itemView.findViewById(R.id.ttDisponivel)

    fun bind(itemLista: ListaCompra) {
        nomeLista.text = itemLista.descricao
        dtcompra.text = itemLista.dtCompra
        repetirlista.text = itemLista.isRecorrente.toString()
        periodolista.text = itemLista.recorrencia
        ttdisponivel.text = itemLista.orcamento
    }
}
