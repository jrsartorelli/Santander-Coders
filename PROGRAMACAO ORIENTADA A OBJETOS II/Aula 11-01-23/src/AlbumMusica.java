public class AlbumMusica {
    private String nome;
    private int id;
    private double preco;
    private String[] musicos;
    private String[] generos;
    private String[] selos;

    public AlbumMusica(String nome, int id, double preco, String[] musicos, String[] generos, String[] selos) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.musicos = musicos;
        this.generos = generos;
        this.selos = selos;
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

    public String[] getMusicos() {
        return musicos;
    }

    public void setMusicos(String[] musicos) {
        this.musicos = musicos;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public String[] getSelos() {
        return selos;
    }

    public void setSelos(String[] selos) {
        this.selos = selos;
    }
}
