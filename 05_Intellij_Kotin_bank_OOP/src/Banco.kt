class Banco {
    private var contas = mutableMapOf<Int, Conta>()
    private var ultimaConta = 0;

    fun abrirConta(cliente : Cliente, saldo : Double) : Conta {
        val novaConta = Conta(ultimaConta++, saldo, cliente)
        contas[novaConta.numero] = novaConta
        return novaConta
    }

    fun encontraConta(numeroConta: Int?) : Conta? {
        if (numeroConta in contas) {
            return contas[numeroConta]
        }
        return null
    }
}