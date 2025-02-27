package com.example.miniprojeto5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesDoEvento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_do_evento)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recupera os dados da atividade passados pela Intent
        val nome = intent.getStringExtra("nome")
        val responsavel = intent.getStringExtra("responsavel")
        val descricao = intent.getStringExtra("descricao")
        val data = intent.getStringExtra("data")

        // Referências aos TextViews
        val textViewNome = findViewById<TextView>(R.id.detalheNomeDoEvento)
        val textViewResponsavel = findViewById<TextView>(R.id.detalheResponsavelDoEvento)
        val textViewDescricao = findViewById<TextView>(R.id.detalheDescricaoDoEvento)
        val textViewData = findViewById<TextView>(R.id.detalheDataDoEvento)

        // Exibe os dados da atividade
        textViewNome.text = nome
        textViewResponsavel.text = responsavel
        textViewDescricao.text = descricao
        textViewData.text = data

        // Configura o botão de voltar
        val btnVoltar = findViewById<Button>(R.id.voltarDestalhesParaLista)
        btnVoltar.setOnClickListener {
            finish() // Fecha a Activity e volta para a tela anterior
        }
    }
}