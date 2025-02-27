package com.example.miniprojeto5.Adapter

import android.content.Context
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miniprojeto5.DetalhesDoEvento
import com.example.miniprojeto5.Evento
import com.example.miniprojeto5.R

class EventoAdapter(
    private val context: Context,
    private val listaEvento: MutableList<Evento>
) : RecyclerView.Adapter<EventoAdapter.EventoViewHolder>(), Parcelable {

    inner class EventoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //Informações que serão exibidas no RecyclerView em ListaDeEventos
        val nome: TextView = itemView.findViewById(R.id.textView9)
        val responsavel: TextView = itemView.findViewById(R.id.textView7)
        val btnDetails: Button = itemView.findViewById(R.id.detalhesDoEvento)
        val btnExcluir: Button = itemView.findViewById(R.id.excluirEvento)
    }

    constructor(parcel: Parcel) : this(
        TODO("context"),
        TODO("listaEvento")
    ) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.evento_item, parent, false)
        return EventoViewHolder(itemLista)
    }

    override fun getItemCount(): Int {
        return listaEvento.size
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val evento = listaEvento[position]

        // Exibe o nome e o responsável pelo evento
        holder.nome.text = evento.nomeDoEvento
        holder.responsavel.text = evento.nomeDoResponsavel

        // Evento de clique no botão de detalhes
        holder.btnDetails.setOnClickListener {
            // Abre a tela de detalhes da atividade
            val intent = Intent(context, DetalhesDoEvento::class.java).apply {
                putExtra("nome", evento.nomeDoEvento)
                putExtra("responsavel", evento.nomeDoResponsavel)
                putExtra("descricao", evento.descricaoDoEvento)
                putExtra("data", evento.dataDoEvento)
            }
            context.startActivity(intent)
        }

        //Evento de clique do botão excluir
        holder.btnExcluir.setOnClickListener {
            // Remove a atividade da lista
            listaEvento.removeAt(position)
            notifyItemRemoved(position) // Notifica o adapter que um item foi removido
            notifyItemRangeChanged(position, listaEvento.size) // Atualiza as posições dos itens restantes
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EventoAdapter> {
        override fun createFromParcel(parcel: Parcel): EventoAdapter {
            return EventoAdapter(parcel)
        }

        override fun newArray(size: Int): Array<EventoAdapter?> {
            return arrayOfNulls(size)
        }
    }

}