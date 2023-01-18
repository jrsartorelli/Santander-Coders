import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @Override
    public void adicionarProduto(Produto produto, Map<TipoProduto, Estoque> estoques) {
        Estoque<AlbumMusica> albumMusicaEstoque = estoques.get(TipoProduto.ALBUM_MUSICA);
        albumMusicaEstoque.adicionarProduto((AlbumMusica) produto);
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
