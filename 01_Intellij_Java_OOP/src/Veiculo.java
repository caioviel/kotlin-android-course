public abstract class Veiculo {

    protected boolean andando;
    protected int passageiros;
    private float velocidade;

    public Veiculo(float pVelocidade) {
        setVelocidade(velocidade);
        andando = false;
        passageiros = 0;
    }

    public void parar() {
        if (!isAndando()) {
            escrever("Veículo já está parado!");
            return;
        }

        escrever("Parando...");
        this.andando = false;
    }

    public void andar() {
        if (isAndando()) {
            escrever("Veículo já está em movimento!");
            return;
        }

        escrever("Andando a " + this.getVelocidade() + " Km/h");
        this.andando = true;
    }

    public void entrarPassageiro() {
        passageiros++;
        escrever("Entrou um passageiro. Total: " + passageiros);
    }

    public void sairPassageiro() {
        if (passageiros <= 0) {
            escrever("Não há mais passageiros neste veículo!");
            return;
        }

        passageiros--;
        escrever("Saiu um passageiro. Total: " + passageiros);
    }

    protected void escrever(String texto) {
        System.out.println(getClass().getSimpleName() + ": " + texto);
    }

    public void setVelocidade(float pVelocidade) {
        if (velocidade <= 0) {
            escrever("Velocidade Inválida!");
            return;
        }

        this.velocidade = velocidade;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public boolean isAndando() {
        return andando;
    }

    public int getPassageiros() {
        return passageiros;
    }
}
