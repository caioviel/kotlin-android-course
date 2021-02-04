package com.example.simpleappkotlin


enum class SEX {
    MASCULINE,
    FEMININE,
    UNDEFINED
}

class Person(pName: String, pSurname: String, pAge: Int) {
    var name  = pName
    var surname = pSurname
    var age = pAge
    var role = ""
    var sex = SEX.UNDEFINED

    fun welcomeMessage() : String {
        if (sex == SEX.FEMININE) {
            return "Seja bem-vinda Sra. $name $surname!\n" +
                    "É um prazer tê-la aqui conosco!"
        }
        else {
            return "Seja bem-vindo Sr. $name $surname"
        }

    }
}