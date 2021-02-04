fun main() {
    var clienteJoao = Cliente("João", "Silva")
    var contaJoao = Conta(1, 0.0, clienteJoao)

    contaJoao.deposito(-1.0)
    contaJoao.deposito(100.0)
    contaJoao.saque(-1.0)
    contaJoao.saque(50.0)
    contaJoao.saque(50.0)
    contaJoao.saque(50.0)

    contaJoao.extrato()


    var clienteMaria = Cliente("Maria", "Souza")
    var contaMaria = Conta(1, 0.0, clienteMaria)

    contaJoao.deposito(-1.0)
    contaJoao.deposito(100.0)
    contaJoao.saque(-1.0)
    contaJoao.saque(50.0)
    contaJoao.saque(50.0)
    contaJoao.saque(50.0)

    contaJoao.extrato()
}