package com.example.simpleappkotlin

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

fun operation_soma(n1: Double, n2: Double) : Double {
    return n1 + n2
}

fun operation_subtracao(n1: Double, n2: Double) : Double {
    return n1 - n2
}

fun operation_multiplicacao(n1: Double, n2: Double) : Double {
    return n1 * n2
}

fun operation_divisao(n1: Double, n2: Double) : Double {
    return n1 / n2
}

class HighOrderFunctionsActivity : AppCompatActivity() {
    lateinit var txtNumber1 : EditText
    lateinit var txtNumber2 : EditText

    lateinit var optGroupOperation : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_order_functions)

        initUi()
    }

    private fun initUi() {
        txtNumber1 = findViewById(R.id.txt_number1)
        txtNumber2 = findViewById(R.id.txt_number2)
        optGroupOperation = findViewById(R.id.opt_group_operation)

        findViewById<Button>(R.id.btn_calc).let {
            it.setOnClickListener { _ -> onBtnCalcClick() }
        }
    }

    fun RadioGroup.getCheckedRadioButtonText() : String {
        val radioButtonID = checkedRadioButtonId
        val radioButton = RadioGroup@this.findViewById<RadioButton>(radioButtonID)
        return radioButton.text.toString()
    }

    private fun onBtnCalcClick() {
        val number1 = txtNumber1.text.toString()!!.toDouble()
        val number2 = txtNumber2.text.toString()!!.toDouble()

        when(optGroupOperation.getCheckedRadioButtonText()) {
            "Soma" -> performOperaction(number1, number2, ::operation_soma)
            "Subtracao" -> performOperaction(number1, number2, ::operation_subtracao)
            "Multiplicação" ->performOperaction(number1, number2, ::operation_multiplicacao)
            "Divisão" -> performOperaction(number1, number2, ::operation_divisao)
        }

    }

    private fun performOperaction(number1: Double, number2: Double, operation : (Double, Double) -> Double) {
        val result = operation(number1, number2)

        Toast.makeText(this, "O resultado da operação é: $result", Toast.LENGTH_LONG).show()
    }


}