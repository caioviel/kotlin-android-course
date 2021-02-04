public class CarroEletrico extends Carro {

    private float cargaBateria;

    public CarroEletrico(String pPlaca, int pNumeroPortas, float pVelocidade) {
        super(pPlaca, pNumeroPortas, pVelocidade);
        this.cargaBateria = 100;
    }

    public CarroEletrico(String pPlaca, int pNumeroPortas, float pVelocidade, float pCargaBateria) {
        super(pPlaca, pNumeroPortas, pVelocidade);
        this.cargaBateria = pCargaBateria;
    }

    @Override
    public void andar() {
        if (this.cargaBateria < 20) {
            escrever("Não tem bateria suficiente para andar...");
            return;
        }

        super.andar();
        this.cargaBateria = this.cargaBateria - 20;
    }

    @Override
    public void parar() {
        super.parar();
        if (getCargaBateria() <= 40) {
            escrever("Carga da Bateria: " + getCargaBateria() + ". Bateria está baixa, melhor carregar.");
            return;
        }

        escrever("Carga da Bateria: " + getCargaBateria());
    }

    public float getCargaBateria() {
        return cargaBateria;
    }

    public void recarregar() {
        this.cargaBateria = 100;
        escrever("Recarga completa!");
    }

    public void recarregar(float pCarga) {
        if (pCarga <= 0 || this.cargaBateria + pCarga > 100) {
            escrever("Carga invalida!");
            return;
        }

        this.cargaBateria = this.cargaBateria + pCarga;
        escrever("Recarregando: " + pCarga + ". Carga após carregamento: " + this.cargaBateria);
    }
}
