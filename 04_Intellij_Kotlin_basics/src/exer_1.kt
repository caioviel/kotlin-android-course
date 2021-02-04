fun soma(valor1 : Double, valor2: Double) : Double {
    return valor1 + valor2
}

fun subtrai(valor1 : Double, valor2: Double) : Double {
    return valor1 - valor2
}

fun multiplica(valor1 : Double, valor2: Double) : Double {
    return valor1 * valor2
}

fun divide(valor1 : Double, valor2: Double) : Double {
    return valor1 / valor2
}

fun main() {
    println("1. Crie uma função para realizar cada uma das seguintes operações matemáticas: soma, subtração, divisão e " +
            "multiplicação e retorne o resultado da respectiva operação.\n")

    println("soma(4.0, 4.0) = ${soma(4.0, 4.0)}")
    println("subtrai(5.0, 0.5) = ${subtrai(5.0, 0.5)}")
    println("multiplica(8.5, 5.5) = ${multiplica(8.5, 5.5)}")
    println("divide(10.0, 2.0) = ${divide(10.0, 2.0)}")
}