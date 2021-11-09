package br.com.fiap.mba3scjo2021_grupoa_listou.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.mba3scjo2021_grupoa_listou.R
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ItemCompra
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra

class ListasAdapter(private val myListas: ArrayList<ListaCompra>, var itemClick: ListaClickListener) :
    RecyclerView.Adapter<ListasAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.item_listas, parent, false)
        return MyViewHolder(view, itemClick!!)
        return MyViewHolder(view, itemClick!!)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        return holder.bind(myListas[position],itemClick)
    }

    interface ListaClickListener {
        fun onItemClick(lista: ListaCompra, position: Int)
    }

    override fun getItemCount(): Int {
        return myListas.size
    }

    private fun getTotalItens(lista: ListaCompra): Float {
        var ttlista: Float = "0.0".toFloat()
        for(item: ItemCompra in lista.itens!!){
            ttlista.plus((item.precoPretendidoUnitario!! * item.quantidade!!.toFloat()))
        }
        return ttlista
    }

    class MyViewHolder(itemView: View, var itemClick: ListaClickListener) : RecyclerView.ViewHolder(itemView) {


        var id: TextView = itemView.findViewById(R.id.id)
        var descricao: TextView = itemView.findViewById(R.id.descricao)
        var dtcompra: TextView = itemView.findViewById(R.id.dtCompra)
        var recorrente: TextView = itemView.findViewById(R.id.recorrente)
        var recorrencia: TextView = itemView.findViewById(R.id.recorrencia)
        var orcamento: TextView = itemView.findViewById(R.id.orcamento)
        var ttlista: TextView = itemView.findViewById(R.id.total_lista)

        fun bind(myLista: ListaCompra?, position: ListaClickListener) {
            descricao.text = myLista!!.descricao
            dtcompra.text = myLista!!.dtCompra
            recorrente.text =myLista!!.recorrente.toString()
            recorrencia.text =myLista!!.recorrencia
            orcamento.text = myLista!!.orcamento
            ttlista.text = getTotalItens(myLista.itens as ArrayList<ItemCompra>).toString()
            itemView.setOnClickListener(View.OnClickListener {
                position.onItemClick(myLista, absoluteAdapterPosition)
            })
        }

        private fun getTotalItens(lista: ArrayList<ItemCompra>): Float {
            var ttlista: Float = "0.0".toFloat()
            for(item: ItemCompra in lista.itens!!){
                ttlista.plus((item.precoPretendidoUnitario!! * item.quantidade!!.toFloat()))
            }
            return ttlista
        }
    }

}