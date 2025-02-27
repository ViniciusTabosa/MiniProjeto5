package com.example.miniprojeto5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miniprojeto5.Adapter.EventoAdapter

class ListaDeEventos : AppCompatActivity() {

    companion object {
        val listaEvento = mutableListOf<Evento>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_eventos)

        //Cria o componente RecyclerView
        val recyclerViewListaDeEventos = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerViewListaDeEventos.layoutManager = LinearLayoutManager(this)
        recyclerViewListaDeEventos.setHasFixedSize(true)


        val adapter = EventoAdapter(this, listaEvento)
        recyclerViewListaDeEventos.adapter = adapter

        // Configurando o botão de voltar dessa tela
        val btn_Voltar = findViewById<Button>(R.id.voltarListaParaMain)

        btn_Voltar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}