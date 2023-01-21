public class Caixa {
    private double saldo;

    public Caixa() {
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarDinheiro(double dinheiro){
        this.saldo = dinheiro;
    }

    public boolean retirarDinheiro(double dinheiro){
        if (this.saldo >= dinheiro){
            this.saldo -= dinheiro;
            return true;
        }
        return false;
    }
}
