package br.com.fiap.mba3scjo2021_grupoa_listou.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.mba3scjo2021_grupoa_listou.ListaActivity
import br.com.fiap.mba3scjo2021_grupoa_listou.R
import br.com.fiap.mba3scjo2021_grupoa_listou.databinding.ItemListasBinding
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra

public class ListasAdapter(private var c:Context, private val listas: List<ListaCompra>) :
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
        val listas = listas[position]
        holder.v.isListaCompra = listas
        holder.v.root.setOnClickListener {
            var listaIntent = Intent(c, ListaActivity::class.java)
            listaIntent.putExtra("descricao", listas.descricao)
            listaIntent.putExtra("dtCompra", listas.dtCompra)
            listaIntent.putExtra("isRecorrente", listas.isRecorrente)
            listaIntent.putExtra("recorrencia", listas.recorrencia)
            listaIntent.putExtra("orcamento", listas.orcamento)
            c.startActivity(listaIntent)
        }
    }

    override fun getItemCount(): Int = listas.size


    inner class MyViewHolder(val v: ItemListasBinding) : RecyclerView.ViewHolder(v.root) {

        init {
            v.root.setOnClickListener{
                val position: Int = adapterPosition

                Toast.makeText(v.root.context,"$position",Toast.LENGTH_SHORT).show()
            }
        }
    }
    /*{
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