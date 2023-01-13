public class AlbumMusica extends Produto{
    private String[] musicos;
    private String[] generos;
    private String[] selos;

    public AlbumMusica(String nome, double preco, int quantidade, String[] musicos, String[] generos, String[] selos) {
        this.setNome(nome);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.musicos = musicos;
        this.generos = generos;
        this.selos = selos;
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
