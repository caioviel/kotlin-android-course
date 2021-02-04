package com.example.simpleappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.StringBuilder
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

val Person.isUnderage : Boolean by UnderageCheck()

class UnderageCheck : ReadOnlyProperty<Person, Boolean> {
    override fun getValue(thisRef: Person, property: KProperty<*>): Boolean {
        return thisRef.age < 18
    }

}

class ExtensionDelegateActivity : AppCompatActivity() {
    lateinit var txtName : EditText
    lateinit var txtSurname : EditText
    lateinit var txtAge : EditText
    lateinit var btnOk : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_delegate)

        initUi()
    }

    private fun initUi() {
        txtName = findViewById(R.id.txt_name)
        txtSurname = findViewById(R.id.txt_surname)
        txtAge = findViewById(R.id.txt_age)
        btnOk = findViewById(R.id.btn_ok)

        btnOk.setOnClickListener { _ -> onBtnOkClick() }

    }

    private fun onBtnOkClick() {
        val name = txtName.text.toString()
        val surname = txtSurname.text.toString()
        val age = txtAge.text.toString()!!.toInt()

        val person = Person(name, surname, age)
        var sb = StringBuilder()

        if (person.isUnderage) {
            Toast.makeText(this,
                "${person.name} é menor de idade!",
                Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,
                "${person.name} é maior de idade!",
                Toast.LENGTH_SHORT).show();
        }
    }
}