public class Livro {
    private String nome;
    private int id;
    private double preco;
    private String[] generos;
    private String escritor;
    private String editora;

    public Livro(String nome, int id, double preco, String[] generos, String escritor, String editora) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.generos = generos;
        this.escritor = escritor;
        this.editora = editora;
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

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}