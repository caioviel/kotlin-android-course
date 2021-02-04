import java.lang.StringBuilder

fun main() {
    println("5. Crie uma função que recebe uma string e a inverte. Ex: amor -> roma. Depois disso, retorne esta string " +
            "com uma letra acima no alfabeto. Ex: roma -> spnb.")

    println("Digite uma palavra:")
    var palavra = readLine().toString()

    var palavraInvertida = StringBuilder()
    for (i in palavra.length-1 downTo 0) {
        palavraInvertida.append(palavra[i])
    }
    println("\"$palavra\" invertida é \"${palavraInvertida.toString()}\"")

    var palavraAcima = StringBuilder()
    for (i in palavra) {
        palavraAcima.append(i+1)
    }
    println("\"$palavra\" com uma letra acima é é \"${palavraAcima.toString()}\"")
}