public class Carro extends Veiculo {

    protected String placa;
    protected int numeroPortas;
    private boolean portaAberta;

    public Carro(String pPlaca, int pNumeroPortas, float pVelocidade) {
        super(pVelocidade);
        this.numeroPortas = pNumeroPortas;
        this.placa = pPlaca;
        this.portaAberta = false;

        escrever("Instanciado com placa '" + this.placa + "' e " + this.numeroPortas + " portas");
    }

    @Override
    public void parar() {
        if (isPortaAberta()) {
            escrever("Não pode parar com a porta aberta!");
            return;
        }

        super.parar();
    }

    @Override
    public void andar() {
        if (isPortaAberta()) {
            escrever("Não pode começar a andar com a porta aberta!");
            return;
        }

        super.andar();
    }

    public void andar(String sentido) {
        if (isPortaAberta()) {
            escrever("Não pode começar a andar com a porta aberta!");
            return;
        }

        escrever("Andando a " + this.getVelocidade() + " Km/h para " + sentido);
        this.andando = true;
    }

    @Override
    public void entrarPassageiro() {
        if (isAndando() || !isPortaAberta()) {
            escrever("Pare e abra a porta para os passageiros poderem entrar!");
            return;
        }

        if (getPassageiros() == 4) {
            escrever("Não cabem mais passageiros neste carro!");
            return;
        }

        super.entrarPassageiro();
    }

    @Override
    public void sairPassageiro() {
        if (isAndando() || !isPortaAberta()) {
            escrever("Pare e abra a porta para os passageiros poderem sair!");
            return;
        }

        super.sairPassageiro();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String pPlaca) {
        this.placa = pPlaca;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int pNumeroPortas) {
        this.numeroPortas = pNumeroPortas;
    }

    public void abrirPorta() {
        if (isAndando()) {
            escrever("Não pode abrir a porta com o carro andando!");
            return;
        }

        if (isPortaAberta()) {
            escrever("Portas já estão abertas!");
        }

        escrever("Abrindo portas...");
        portaAberta = true;
    }

    public void fecharPorta() {
        if (!isPortaAberta()) {
            escrever("Portas já estão fechadas!");
            return;
        }

        escrever("Fechando portas...");
        portaAberta = false;
    }

    public boolean isPortaAberta() {
        return portaAberta;
    }
}
