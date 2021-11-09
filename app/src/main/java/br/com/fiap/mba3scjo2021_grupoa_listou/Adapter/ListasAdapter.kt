package br.com.fiap.mba3scjo2021_grupoa_listou.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.mba3scjo2021_grupoa_listou.R
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra

class ListasAdapter(private val myListas: ArrayList<ListaCompra>, var itemClick: ListaClickListener?) :
    RecyclerView.Adapter<ListasAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.item_listas, parent, false)
        return MyViewHolder(view, itemClick!!)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        return holder.bind(myListas,position)
    }

    interface ListaClickListener {
        fun getLista(position: Int)
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

        fun bind(myListas: ArrayList<ListaCompra>?, position: Int) {
            descricao.text = myListas!!.get(position).descricao
            dtcompra.text = myListas!!.get(position).dtCompra
            recorrente.text =myListas!!.get(position).recorrente.toString()
            recorrencia.text =myListas!!.get(position).recorrencia
            orcamento.text =myListas!!.get(position).orcamento
            itemView.setOnClickListener(View.OnClickListener {
                itemClick.getLista(absoluteAdapterPosition)
            })
        }
    }
}