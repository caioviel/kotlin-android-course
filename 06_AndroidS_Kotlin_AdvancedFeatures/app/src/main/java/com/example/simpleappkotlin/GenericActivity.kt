package com.example.simpleappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

class GenericActivity : AppCompatActivity() {
    private lateinit var console : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generic)

        console = findViewById(R.id.lbl_console)
        console.text = "-----SCREEN CONSOLE - Generics Test-----\n"
        test()
    }

    private fun test() {
        screenlog("Vamos começar colocando strings no console...")
        val myString = "String de teste"
        screenlog(myString)

        screenlog("Agora vamos colocar um número inteiro")
        val myInt = 1
        screenlog(myInt)

        screenlog("Agora vamos colocar um número de ponto flutuante")
        val myDouble = 1.0
        screenlog(myDouble)

        screenlog("Agora vamos colocar o próprio TextView")
        screenlog(console)

        screenlog("Agora vamos colocar a pŕopria activity")
        screenlog(this)

        screenlog("Agora vamos colocar uma instância de Person")
        val person = Person("Caio", "Viel", 85)
        screenlog(person)
    }

    fun <T> screenlog(obj : T) {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        var sb = StringBuilder().apply {
            append(console.text.toString())
            append("\n")
            append("$timeStamp - ${obj.toString()}")
            append("\n")
        }
        console.text = sb.toString()
    }
}