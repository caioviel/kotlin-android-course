import kotlin.random.Random

var banco = inicializarBanco(100)

fun main() {
    println("Bem-Vindo ao Banco!\n")
    while(true) {
        println("Escolha a opçção desejada:")
        println("\t(1) Ver Extrato")
        println("\t(2) Sacar")
        println("\t(3) Depositar")
        println("\t(4) Transferir")
        println("\t(5) Sair")

        when(readLine()?.toInt()) {
            1 -> extrato()
            2 -> sacar()
            3 -> depositar()
            4 -> transferir()
            5 -> {break}
            else -> println("Opção invalida!")
        }
    }
}

fun inicializarBanco(clientes : Int) : Banco {
    println("Inicializando o banco...")
    var banco = Banco()

    for (index in 1 .. clientes) {
        val cliente = Cliente("Fulano de tal $index", "Da Silva")
        val saldoInicial = Random.nextDouble(0.0, 1.0) * 1000.0
        banco.abrirConta(cliente, saldoInicial)
    }

    return banco
}

fun extrato() {
    println("\nEntre com o número da conta:")
    val numeroConta = readLine()!!.toInt()
    val conta = banco.encontraConta(numeroConta)
    if (conta === null) {
        println("Conta invalida!")
        return
    }

    conta.extrato()
}

fun depositar() {
    println("\nEntre com o número da conta:")
    val numeroConta = readLine()!!.toInt()
    var conta = banco.encontraConta(numeroConta)
    if (conta === null) {
        println("Conta invalida!")
        return
    }

    println("Entre com o valor:")
    val valor = readLine()!!.toDouble()
    conta.deposito(valor)
}

fun sacar() {
    println("\nEntre com o número da conta:")
    val numeroConta = readLine()!!.toInt()
    var conta = banco.encontraConta(numeroConta)
    if (conta === null) {
        println("Conta invalida!")
        return
    }

    println("Entre com o valor:")
    val valor = readLine()!!.toDouble()
    conta.saque(valor)
}

fun transferir() {
    println("\nEntre com o número da conta sacante:")
    val numeroConta1 = readLine()!!.toInt()
    var contaSacante = banco.encontraConta(numeroConta1)
    if (contaSacante === null) {
        println("Conta invalida!")
        return
    }

    println("\nEntre com o número da conta depositante:")
    val numeroConta2 = readLine()!!.toInt()
    var contaDepositante = banco.encontraConta(numeroConta2)
    if (contaDepositante === null) {
        println("Conta invalida!")
        return
    }

    println("Entre com o valor:")
    val valor = readLine()!!.toDouble()
    if (contaSacante.saque(valor)) {
        contaDepositante.deposito((valor))
    }
}
