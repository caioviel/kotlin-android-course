import kotlin.math.sqrt

fun main() {
    println("2. Peça para o usuário digitar um número e printe na tela o número ao quadrado e sua raiz quadrada.\n")

    println("Digite um número: ")
    var numero = readLine()!!.toDouble()

    println("$numero elavado ao quadrado: ${numero*numero}")
    println("Raiz quadrada de $numero: ${sqrt(numero)}")
}