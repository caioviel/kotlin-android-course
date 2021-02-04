fun main() {
    println("6. Calculadora automatizada: Peça para o usuário digitar um número, depois uma operação matemática " +
            "(+, -, /, *), depois um segundo número. Agora printe o resultado.")

    println("Digite o primeiro numero:")
    var numero1 = readLine()!!.toDouble()

    var operacao = ""
    while (true) {
        println("Digite a operaçao (+, -, /, *):")
        operacao = readLine().toString()
        when(operacao) {
            "+", "-", "/", "*" -> break
            else -> println("Opção invalida!\n")
        }
    }

    println("Digite o segundo numero:")
    var numero2 = readLine()!!.toDouble()

    when (operacao) {
        "+" -> println("$numero1 + $numero2 = ${numero1 + numero2}")
        "-" -> println("$numero1 - $numero2 = ${numero1 - numero2}")
        "*" -> println("$numero1 * $numero2 = ${numero1 * numero2}")
        "/" -> println("$numero1 / $numero2 = ${numero1 / numero2}")
    }

}