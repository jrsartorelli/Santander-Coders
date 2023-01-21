import java.util.Arrays;

public class AlbumMusica extends Produto{
    private String[] musicos;
    private String[] generos;
    private String[] selos;

    public AlbumMusica(String nome, Integer id, double preco, int quantidade, boolean publicoAdulto, String[] musicos, String[] generos, String[] selos) {
        this.setNome(nome);
        this.setId(id);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.setPublicoAdulto(publicoAdulto);
        this.setTipoProduto(TipoProduto.ALBUM_MUSICA);
        this.musicos = musicos;
        this.generos = generos;
        this.selos = selos;
    }

    @Override
    public String toString() {
        return "AlbumMusica{" + super.toString() +
                ", musicos=" + Arrays.toString(musicos) +
                ", generos=" + Arrays.toString(generos) +
                ", selos=" + Arrays.toString(selos) +
                '}';
    }
}
