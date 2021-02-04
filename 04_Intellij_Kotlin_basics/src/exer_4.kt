fun main() {
    println("4. Faça uma função que recebe uma palavra digitada pelo usuário e printe na tela apenas as últimas 3 letras " +
            "da palavra. Exemplo: “cinco”. Saída: “nco”.")

    println("Digita uma palavra:")
    var palavra = readLine().toString()

    var ultimos3Digitos = palavra.substring(palavra.length-3)
    println("Ultimos 3 digitos: $ultimos3Digitos")

}