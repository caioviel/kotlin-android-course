public class Limousine extends Carro implements CarroDeLuxo {

    private final static int NUMERO_DE_PORTAS = 8;

    private String bebida;
    private boolean bebidaServida;

    public Limousine(String pPlaca, float pVelocidade, String pBebida) {
        super(pPlaca, NUMERO_DE_PORTAS, pVelocidade);
        this.bebida = pBebida;
        this.bebidaServida = false;
    }

    @Override
    public void chamarMordono() {
        if (getPassageiros() < 1) {
            escrever("Não hás passageiros nesta limousine para chamar o mordono!");
            return;
        }

        escrever("Chamando o mordono...");
    }

    @Override
    public void jogarPlayStation5() {
        if (getPassageiros() < 1) {
            escrever("Não hás passageiros nesta limousine para jogar PlayStation5!");
            return;
        }

        escrever("Jogando PlayStation5...");
    }

    @Override
    public void ligarParaOPresidente() {
        if (getPassageiros() < 1) {
            escrever("Não hás passageiros nesta limousine para ligar para o presidente!");
            return;
        }

        escrever("Ligando para o presidente...");
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String pBebida) {
        this.bebida = pBebida;
    }

    public void servirBebida() {
        escrever("Servindo " + this.getBebida() + "..." );
        this.bebidaServida = true;
    }

    @Override
    public void entrarPassageiro() {
        if (isAndando() || !isPortaAberta()) {
            escrever("Pare e abra a porta para os passageiros poderem entrar!");
            return;
        }

        if (getPassageiros() == 12) {
            escrever("Não cabem mais passageiros neste carro!");
            return;
        }

        passageiros++;
        escrever("Entrou um passageiro. Total: " + passageiros);
    }

    @Override
    public void parar() {
        if (isBebidaServida()) {
            escrever("Segure o(a) " + this.bebida + " pois a limousine irá parar!");
        }
        super.parar();
    }

    private boolean isBebidaServida() {
        return bebidaServida;
    }
}
