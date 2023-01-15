public class Jogo extends Produto{
    private String distribuidora;
    private String genero;
    private String estudioDesenvolvedor;

    public Jogo(String nome, Integer id, double preco, int quantidade, String distribuidora, String genero, String estudioDesenvolvedor) {
        this.setNome(nome);
        this.setId(id);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.distribuidora = distribuidora;
        this.genero = genero;
        this.estudioDesenvolvedor = estudioDesenvolvedor;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstudioDesenvolvedor() {
        return estudioDesenvolvedor;
    }

    public void setEstudioDesenvolvedor(String estudioDesenvolvedor) {
        this.estudioDesenvolvedor = estudioDesenvolvedor;
    }
}