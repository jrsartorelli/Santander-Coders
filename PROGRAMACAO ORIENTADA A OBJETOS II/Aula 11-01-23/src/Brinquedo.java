public class Brinquedo extends Produto{
    private String tipo;

    public Brinquedo(String nome, double preco, int quantidade, String tipo) {
        this.setNome(nome);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}