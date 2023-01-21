public class Desconto {
    private double percentualDesconto;
    private double valorCondicao;

    public Desconto(double percentualDesconto, double valorCondicao) {
        this.percentualDesconto = percentualDesconto;
        this.valorCondicao = valorCondicao;
    }

    public double calcularDesconto(double valorOriginal){
        if (valorOriginal >= valorCondicao) {
            return valorOriginal * percentualDesconto;
        }
        return 0;
    }
}
