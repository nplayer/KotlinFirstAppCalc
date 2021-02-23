package com.example.calculadoradenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular = calcular
        val resultado = resultado

        btCalcular.setOnClickListener{
            val nota1 = nota1.text.toString().toIntOrNull()?: 0
            val nota2 = nota2.text.toString().toIntOrNull()?: 0
            val media = (nota1 + nota2) / 2.0
            val faltas = faltas.text.toString().toIntOrNull()?: -1

            if (faltas<0){
                resultado.setText("!!!Erro!!!\nNúmero de faltas inválido!!!\nDigite novamente")
                resultado.setTextColor(Color.RED)
            }
            else{
                if(media >= 6.0 && faltas <= 10){
                    resultado.setText("Aluno foi Aprovado!!\n"+"Nota Final: " + media +
                            "\nFaltas: " + faltas  )
                    resultado.setTextColor(Color.GREEN)
                }
                else{
                    resultado.setText("Aluno foi Reprovado!!\n"+"Nota Final: " + media +
                            "\nFaltas: " + faltas  )
                    resultado.setTextColor(Color.RED)
                }
            }
        }
    }
}