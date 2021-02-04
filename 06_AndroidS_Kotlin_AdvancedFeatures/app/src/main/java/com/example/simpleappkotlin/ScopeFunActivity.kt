package com.example.simpleappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.StringBuilder
import kotlin.random.Random

class ScopeFunActivity : AppCompatActivity() {
    lateinit var txtName : EditText
    lateinit var txtSurname : EditText
    lateinit var txtAge : EditText
    lateinit var btnOk : Button
    lateinit var lblConsole : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope_fun)

        initUi()
    }

    private fun initUi() {
        txtName = findViewById(R.id.txt_name)
        txtSurname = findViewById(R.id.txt_surname)
        txtAge = findViewById(R.id.txt_age)
        btnOk = findViewById(R.id.btn_ok)
        lblConsole = findViewById(R.id.lbl_console)

        btnOk.setOnClickListener { _ -> onBtnOkClick() }

    }

    private fun onBtnOkClick() {
        val name = txtName.text.toString()
        val surname = txtSurname.text.toString()
        val age = txtAge.text.toString()!!.toInt()

        var person = Person(name, surname, age)

        // Testing Apply with string builder
        var sb = StringBuilder().apply {
            append("Testando as scoped function:\n\n")

            append("(1) Inicialmente estamos usando APPLY sobre uma StringBuilder() para construir esta string.\n\n")

            append("(2) A mensagem abaixo foi construída utilizando RUN:\n\t")
            append(person.run {
                sex = SEX.MASCULINE

                welcomeMessage() //A mensagem é retornada pelo run
            })
            append("\n\n")
        }

        with(sb) {
            append("(3) Agora saimos do APPLY e estamos usando WITH sobre a StringBuilder\n\n")

            append("(4) A mensgem abaixo foi construída usando LET:\n\t")
        }

        person.let {
            sb.append("${it.name} tem ${it.age} anos de idade\n\n")
        }

       sb.also {
           it.append("(5) Por fim, vamos usar ALSO sobre o StringBuffer para setar o valor deste EditText")
           lblConsole.text = it.toString()
        }


    }

}