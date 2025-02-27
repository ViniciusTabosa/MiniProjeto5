package com.example.miniprojeto5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroDeAtividades : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_de_atividades)

        // Referências aos componentes do layout
        val editTextEvento = findViewById<EditText>(R.id.editTextEvento)
        val editTextResponsavel = findViewById<EditText>(R.id.editTextResponsavel)
        val editTextData = findViewById<EditText>(R.id.editTextData)
        val editTextDescricao = findViewById<EditText>(R.id.editTextDescricao)
        val buttonCadastrar = findViewById<Button>(R.id.cadastrar)
        val btnVoltar = findViewById<Button>(R.id.voltarCadastroParaMain)

        // Evento do botão de voltar
        btnVoltar.setOnClickListener {
            // Intent para abrir a CadastroDeAtividades
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Evento do botão Cadastrar
        buttonCadastrar.setOnClickListener {
            // Obtém os valores dos campos
            val evento = editTextEvento.text.toString()
            val responsavel = editTextResponsavel.text.toString()
            val data = editTextData.text.toString()
            val descricao = editTextDescricao.text.toString()


            // Verifica se os campos estão preenchidos
            if (evento.isNotEmpty() && responsavel.isNotEmpty() && data.isNotEmpty() && descricao.isNotEmpty()) {
                val novoEvento = Evento(
                    nomeDoEvento = evento,
                    nomeDoResponsavel = responsavel,
                    dataDoEvento = data,
                    descricaoDoEvento = descricao,
                    eventoConcluido = false
                )

                ListaDeEventos.listaEvento.add(novoEvento)

                // Exibe uma mensagem de sucesso ao cadastrar
                Toast.makeText(this, "Evento cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

                // Limpa os campos após o cadastro
                editTextEvento.text.clear()
                editTextResponsavel.text.clear()
                editTextData.text.clear()
                editTextDescricao.text.clear()

                startActivity(intent)
            } else {
                // Exibe uma mensagem de erro se algum campo estiver vazio
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}