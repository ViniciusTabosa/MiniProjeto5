package com.example.miniprojeto5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencia os botões à variáveis
        val btnCadastrarEventos = findViewById<Button>(R.id.cadastrarEventos)
        val btnListarEventos = findViewById<Button>(R.id.listarEventos)

        // Evento do botão Cadastrar novo evento
        btnCadastrarEventos.setOnClickListener {
            // Intent para abrir a CadastroDeAtividades
            val intent = Intent(this, CadastroDeAtividades::class.java)
            startActivity(intent)
        }

        // Evento do botão Lista de eventos cadastrados
        btnListarEventos.setOnClickListener {
            // Cria uma Intent para abrir a ListaDeEventos
            val intent = Intent(this, ListaDeEventos::class.java)
            startActivity(intent)
        }
    }
}