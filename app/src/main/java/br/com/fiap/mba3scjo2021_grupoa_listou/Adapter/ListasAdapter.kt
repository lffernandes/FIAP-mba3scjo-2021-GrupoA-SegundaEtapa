package br.com.fiap.mba3scjo2021_grupoa_listou.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.mba3scjo2021_grupoa_listou.R
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


    class MyViewHolder(itemView: View, var itemClick: ListaClickListener) : RecyclerView.ViewHolder(itemView) {


        var id: TextView = itemView.findViewById(R.id.id)
        var descricao: TextView = itemView.findViewById(R.id.descricao)
        var dtcompra: TextView = itemView.findViewById(R.id.dtCompra)
        var recorrente: TextView = itemView.findViewById(R.id.recorrente)
        var recorrencia: TextView = itemView.findViewById(R.id.recorrencia)
        var orcamento: TextView = itemView.findViewById(R.id.orcamento)

        fun bind(myLista: ListaCompra?, position: ListaClickListener) {
            descricao.text = myLista!!.descricao
            dtcompra.text = myLista!!.dtCompra
            recorrente.text =myLista!!.recorrente.toString()
            recorrencia.text =myLista!!.recorrencia
            orcamento.text =myLista!!.orcamento
            itemView.setOnClickListener(View.OnClickListener {
                position.onItemClick(myLista, absoluteAdapterPosition)
            })
        }
    }
}