import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        exec_04_comportamento_hierarquia_classes();
        exec_07_sobrecarga_sobrescrita_andar_parar();
        exec_08_polimorfismo();
        exec_09_implementa_CarroDeLuxo();
    }

    public static void exec_04_comportamento_hierarquia_classes() {
        /*
            Foi adicionado o novo método sairPassageiro() e entrarPassageiro() a Veiculo e todas as suas sub-classes.

            Os métodos foram sobrescritos em carro para não permitir entrada e saida de passageiros com o carro em
            movimento ou com as portas fechadas. O número máximo de passageiros foi definido como 4.

            Em Limousine, entrarPassageiro() foi sobrescritor para permitir até 8 passgeiros.
         */

        System.out.println("04. Testando o novo comportamento sairPassageiro() e entrarPassageiro() em toda a hierarquia de classes\n");

        Carro carro = new Carro("ABC-1234", 4, 120);
        carro.entrarPassageiro();

        carro.abrirPorta();
        carro.entrarPassageiro();
        carro.andar();
        carro.fecharPorta();
        carro.andar();
        carro.sairPassageiro();
        carro.parar();
        carro.abrirPorta();
        carro.sairPassageiro();
        carro.sairPassageiro();
        carro.andar();
        System.out.println();

        CarroEletrico eletrico = new CarroEletrico("TSL-1234", 2, 100);
        eletrico.abrirPorta();
        eletrico.entrarPassageiro();
        eletrico.entrarPassageiro();
        eletrico.entrarPassageiro();
        eletrico.entrarPassageiro();
        eletrico.entrarPassageiro();
        eletrico.fecharPorta();
        eletrico.andar();
        eletrico.sairPassageiro();
        System.out.println();

        Limousine limo = new Limousine("LIM-1234", 140, "whisk");
        limo.abrirPorta();
        limo.entrarPassageiro();
        limo.entrarPassageiro();
        limo.entrarPassageiro();
        limo.entrarPassageiro();
        limo.entrarPassageiro();
        limo.entrarPassageiro();
        limo.entrarPassageiro();
        limo.entrarPassageiro();
        limo.fecharPorta();
        limo.andar();
        limo.sairPassageiro();
        System.out.println();
    }

    public static void exec_07_sobrecarga_sobrescrita_andar_parar() {
        /*
            Veículos em movimento não podem andar(). Veículos parados não podem parar()

            Carro só pode andar se suas portas estiverem fechadas.

            Carro pode ir numa direção especifica ao andar. Podem mudar de direção sem precisar parar.

            CarroEletrico consumem bateria para andar e precisam ter um nível suficiente de bateria para começar a andar.

            Limousine precisa tomar cuidado para parar caso a bebida tenha sido servida.
         */

        System.out.println("07. Testando sobrecarga de andar() e sobrescrita de parar() em Carro, CarroEletrico e Limousine\n");

        Carro carro = new Carro("ABC-1234", 4, 120);
        carro.abrirPorta();
        carro.andar();
        carro.andar("Norte");
        carro.fecharPorta();
        carro.andar();
        carro.andar();
        carro.parar();
        carro.parar();
        carro.andar("Norte");
        carro.andar("Sul");
        System.out.println();

        CarroEletrico eletrico = new CarroEletrico("TSL-1234", 2, 100);
        eletrico.andar();
        eletrico.parar();
        eletrico.andar();
        eletrico.parar();
        eletrico.andar();
        eletrico.parar();
        eletrico.andar();
        eletrico.parar();
        eletrico.andar();
        eletrico.parar();
        eletrico.andar();
        eletrico.recarregar();
        eletrico.andar();
        System.out.println();

        Limousine limo = new Limousine("LIM-1234", 140, "whisk");
        limo.andar();
        limo.parar();
        limo.andar();
        limo.servirBebida();
        limo.parar();
        System.out.println();
    }

    public static void exec_08_polimorfismo() {
        /*
            filaEstacionamento é um array de carros.

            Cada carro para, abre as portas, pega um passageiro, fecha as portas, começa a andar (se puder...)
            leva o passageiro até o destino, abre a porta e o passageiro sai.
         */

        System.out.println("08. Poliformismo de Carro e suas sub-classes\n");

        ArrayList<Carro> filaEstacionamento = new ArrayList<Carro>();

        filaEstacionamento.add(new Carro("ABC-1234", 4, 120));
        filaEstacionamento.add(new Carro("ABC-5678", 2, 120));

        filaEstacionamento.add(new CarroEletrico("TSL-1234", 4, 100));
        filaEstacionamento.add(new CarroEletrico("TSL-5678", 4, 100, 0));

        filaEstacionamento.add(new Limousine("LIM-1234", 120, "Whisk"));
        filaEstacionamento.add(new Limousine("LIM-5678", 120, "Vinho"));

        for (Carro carro : filaEstacionamento) {
            System.out.println("\nPlaca: " + carro.getPlaca());
            carro.abrirPorta();
            carro.entrarPassageiro();
            carro.fecharPorta();
            carro.andar();
            carro.parar();
            carro.abrirPorta();
            carro.sairPassageiro();
        }

    }

    public static void exec_09_implementa_CarroDeLuxo() {
        /*
            Limousine é um CarroDeLuxo

            Dentro de uma Limousine (os passageiros) podem chamar o mordono, jogar play station 5 e ligar para o presidente.
         */

        System.out.println("10. Limousine implmenta a interface CaroDeLuxo\n");

        Limousine limo = new Limousine("LIM-1234", 140, "whisk");
        limo.chamarMordono();
        limo.jogarPlayStation5();
        limo.ligarParaOPresidente();
        limo.abrirPorta();
        limo.entrarPassageiro();
        limo.fecharPorta();
        limo.andar("Sul");
        limo.chamarMordono();
        limo.servirBebida();
        limo.jogarPlayStation5();
        limo.ligarParaOPresidente();
        limo.parar();
    }


}
