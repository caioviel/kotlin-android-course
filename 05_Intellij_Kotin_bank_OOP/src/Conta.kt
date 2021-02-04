enum class TIPO_OPERACAO {
    ABERTURA,
    SAQUE,
    DEPOSITO
}

data class Operacao (val tipo : TIPO_OPERACAO, val valor : Double) {}

class Conta(pConta : Int, pSaldo : Double, pCliente : Cliente) {
    val numero = pConta
    var saldo = pSaldo
    val cliente = pCliente

    var operacoes = mutableListOf<Operacao>(Operacao(TIPO_OPERACAO.ABERTURA, pSaldo)) // Armazena as últimas 10 operacoes

    fun deposito(valor : Double) : Boolean {
        if (valor < 0.0) {
            println("Por favor, informe um valor positivo.\n")
            return false
        }

        println("Depositando na conta $numero o valor de $valor\n")
        saldo += valor
        println("Saldo Resultante: $saldo\n")
        salvar_operacao(Operacao(TIPO_OPERACAO.DEPOSITO, valor))
        return true
    }

    fun saque(valor : Double) : Boolean {
        if (valor < 0.0) {
            println("Por favor, informe um valor positivo.\n")
            return false;
        }

        if (valor > saldo) {
            println("Saldo Insuficiente.\n")
            return false;
        }

        println("Sacando da conta $numero o valor de $valor\n")
        saldo -= valor
        println("Saldo Resultante: $saldo\n")
        salvar_operacao(Operacao(TIPO_OPERACAO.SAQUE, valor))
        return true;
    }

    fun extrato() {
        println("-------------Extrato-------------")
        println("Número da Conta: $numero")
        println("Cliente: ${cliente.sobrenome.toUpperCase()}, ${cliente.nome}")
        println("Saldo: ${saldo}")
        println("\nUltimos Lançamentos:")
        for (operacao in operacoes) {
            operacao.apply {
                if (tipo == TIPO_OPERACAO.SAQUE) {
                    println("\t${tipo.toString()}\t\t${valor}")
                } else {
                    println("\t${tipo.toString()}\t${valor}")
                }
            }

        }

        println("-------------Extrato-------------\n")

    }

    private fun salvar_operacao(operacao : Operacao) {
        if (operacoes.size >= 10) {
            operacoes.removeFirst()
        }

        operacoes.add(operacao)
    }

}