package br.com.fiap.mba3scjo2021_grupoa_listou.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.mba3scjo2021_grupoa_listou.R
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra
import kotlinx.android.synthetic.main.compra_item.view.*

class ListasAdapter(
    private val listas: List<ListaCompra>,
) : RecyclerView.Adapter<ListasAdapter.ListasViewHolder>() {

    class ListasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindListas(lista: ListaCompra) {
            itemView.id = lista.id
            itemView.nomeLista.text = lista.descricao
            itemView.repetirLista.text = lista.isRecorrente.toString()
            itemView.PeriodoLista.text = lista.recorrencia
            itemView.ttDisponivel.text = lista.orcamento
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListasViewHolder {
        return ListasViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.compra_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListasViewHolder, position: Int) {
        holder.bindListas(listas.get(position))
    }

    override fun getItemCount(): Int = listas.size
}
