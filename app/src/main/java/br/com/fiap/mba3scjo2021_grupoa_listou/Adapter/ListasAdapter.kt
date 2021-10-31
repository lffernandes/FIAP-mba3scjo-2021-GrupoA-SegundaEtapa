package br.com.fiap.mba3scjo2021_grupoa_listou.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.mba3scjo2021_grupoa_listou.R
import br.com.fiap.mba3scjo2021_grupoa_listou.databinding.ItemListasBinding
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra

public class ListasAdapter(private val listas: List<ListaCompra>) :
    RecyclerView.Adapter<ListasAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val infalter = LayoutInflater.from(viewGroup.context)
        val itemview = DataBindingUtil.inflate<ItemListasBinding>(infalter,
            R.layout.item_listas,
            viewGroup,
            false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.V.isListaCompra = listas[position]
    }

    override fun getItemCount(): Int = listas.size


    inner class MyViewHolder(val V: ItemListasBinding) : RecyclerView.ViewHolder(V.root) /*{
        val nomeLista: TextView = itemview.findViewById(R.id.nomeLista)
        val dtcompra: TextView = itemview.findViewById(R.id.dtCompra)
        val repetirlista: TextView = itemview.findViewById(R.id.repetirLista)
        val periodolista: TextView = itemview.findViewById(R.id.PeriodoLista)
        val ttdisponivel: TextView = itemview.findViewById(R.id.ttDisponivel)

        fun bindBiew(itemLista: ListaCompra) {
            nomeLista.text = itemLista.descricao
            dtcompra.text = itemLista.dtCompra
            repetirlista.text = itemLista.isRecorrente.toString()
            periodolista.text = itemLista.recorrencia
            ttdisponivel.text = itemLista.orcamento
        }*/
}