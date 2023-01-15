public class Brinquedo extends Produto{
    private String tipo;

    public Brinquedo(String nome, Integer id, double preco, int quantidade, String tipo) {
        this.setNome(nome);
        this.setId(id);
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

    @Override
    public String toString() {
        return "Brinquedo{" + super.toString() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}