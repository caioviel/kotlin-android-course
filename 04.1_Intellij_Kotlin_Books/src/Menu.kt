
val livros = mutableListOf<Livro>()

fun main(){
    while (true) {
        println("a - Cadastrar um novo livro | b - consultar livro | c - vender um livro | outro valor, sai do programa")
        when (readLine()) {
            "a" -> cadastrarLivro()
            "b" -> consultarLivro()
            "c" -> venderLivro()
            else -> break
        }
    }
}

private fun venderLivro() {
    val livroEncontrado = encontrarLivro()

    if (livroEncontrado == null) {
        println("Código não encontado:")
        return;
    }

    println("Digite a quantidade:")
    var quantidade = readLine()!!.toInt()

    if (livroEncontrado.quantidade < quantidade) {
        println("não há exemplares insulficiente!")
        return;
    }

    livroEncontrado.quantidade -= quantidade
    println("$quantidade exemplares de ${livroEncontrado.nome} vendidos!")
}

private fun consultarLivro() {
    val livroEncontrado = encontrarLivro()
    if (livroEncontrado != null) {
        println(livroEncontrado.toString())
    } else {
        println("Código não encontado")
    }
}

private fun cadastrarLivro() {
    println("Código:")
    val codigo = readLine().toString()
    println("Nome:")
    val nome = readLine().toString()
    println("Preco:")
    val preco = readLine()!!.toDouble()
    println("Quantidade:")
    val quantidade = readLine()!!.toInt()
    val livro = Livro(codigo, nome, preco, quantidade)
    livros.add(livro)
}

private fun encontrarLivro() : Livro? {
    println("Digite o código do livro:")
    val codigoDigitado = readLine().toString()

    var livroEncontrado : Livro? = null
    for (livro in livros) {
        if (livro.codigo == codigoDigitado) {
            livroEncontrado = livro
            break
        }
    }

    return livroEncontrado
}