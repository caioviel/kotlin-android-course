fun main() {
    println("3. Peça para o usuário digitar as 3 notas do semestre e calcule sua média (soma das notas dividido pela " +
            "quantidade de notas). A nota digitada não pode ser menor que zero ou maior que 10. Se a média for maior " +
            "ou igual a 6.0 o aluno passou, do contrário está reprovado. Printe na tela a nota com apenas dois dígitos " +
            "após a vírgula e a situação do aluno.\n")

    var totalNotas = 0.0

    for (i in 1..3) {
        while (true) {
            println("Digite a ${i}ª nota:")
            var nota = readLine()!!.toDouble()
            if (nota < 0 || nota > 10.0) {
                println("Nota invalida! Entre um valor entre 0 e 10.\n")
            } else {
                totalNotas += nota
                break
            }
        }
    }

    var media = totalNotas / 3.0
    println("Média Final: ${String.format("%.2f", media)}")
    if (media >= 6.0) {
        println("APROVADO")
    } else {
        println("REPROVADO")
    }
}