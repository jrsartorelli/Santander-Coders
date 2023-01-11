public class Jogo {
    private String nome;
    private int id;
    private double preco;
    private String distribuidora;
    private String genero;
    private String estudioDesenvolvedor;

    public Jogo(String nome, int id, double preco, String distribuidora, String genero, String estudioDesenvolvedor) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.distribuidora = distribuidora;
        this.genero = genero;
        this.estudioDesenvolvedor = estudioDesenvolvedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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