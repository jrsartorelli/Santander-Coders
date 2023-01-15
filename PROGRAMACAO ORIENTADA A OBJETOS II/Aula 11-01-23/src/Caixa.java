public class Caixa {
    private double dinheiro;

    public Caixa() {
        this.dinheiro = 0;
    }

    public Caixa(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void adicionarDinheiro(double dinheiro){
        this.dinheiro = dinheiro;
    }

    public boolean retirarDinheiro(double dinheiro){
        if (this.dinheiro >= dinheiro){
            this.dinheiro -= dinheiro;
            return true;
        }
        return false;
    }
}
