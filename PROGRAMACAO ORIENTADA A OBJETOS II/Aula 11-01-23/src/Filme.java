public class Filme {
    private String nome;
    private int id;
    private double preco;
    private String estudio;
    private String[] diretores;
    private String[] generos;
    private String[] produtores;

    public Filme(String nome, int id, double preco, String estudio, String[] diretores, String[] generos, String[] produtores) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.estudio = estudio;
        this.diretores = diretores;
        this.generos = generos;
        this.produtores = produtores;
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

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String[] getDiretores() {
        return diretores;
    }

    public void setDiretores(String[] diretores) {
        this.diretores = diretores;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public String[] getProdutores() {
        return produtores;
    }

    public void setProdutores(String[] produtores) {
        this.produtores = produtores;
    }
}