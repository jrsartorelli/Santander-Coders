import java.util.ArrayList;
import java.util.List;

public class LivrariaServiceImplement implements LivrariaService{
    private List<Estoque> estoques = new ArrayList<>();

    private Estoque<Livro> estoqueLivros = new Estoque<>();
    private Estoque<Jogo> estoqueJogos = new Estoque<>();
    private Estoque<Brinquedo> estoqueBrinquedos = new Estoque<>();
    private Estoque<Filme> estoqueFilmes = new Estoque<>();
    private Estoque<AlbumMusica> estoqueAlbunsMusica = new Estoque<>();

    public LivrariaServiceImplement() {
        this.estoques.add(estoqueLivros);
        this.estoques.add(estoqueJogos);
        this.estoques.add(estoqueBrinquedos);
        this.estoques.add(estoqueFilmes);
        this.estoques.add(estoqueAlbunsMusica);
    }
}
