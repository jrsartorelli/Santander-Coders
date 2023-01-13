import java.util.ArrayList;
import java.util.List;

public class LivrariaServiceImplement implements LivrariaService {
    private List<Estoque> estoques = new ArrayList<>();

    private Estoque<Livro> estoqueLivros = new Estoque<>(Livro.class);
    private Estoque<Jogo> estoqueJogos = new Estoque<>(Jogo.class);
    private Estoque<Brinquedo> estoqueBrinquedos = new Estoque<>(Brinquedo.class);
    private Estoque<Filme> estoqueFilmes = new Estoque<>(Filme.class);
    private Estoque<AlbumMusica> estoqueAlbunsMusica = new Estoque<>(AlbumMusica.class);

    public LivrariaServiceImplement() {
        this.estoques.add(estoqueLivros);
        this.estoques.add(estoqueJogos);
        this.estoques.add(estoqueBrinquedos);
        this.estoques.add(estoqueFilmes);
        this.estoques.add(estoqueAlbunsMusica);
    }

//    @Override
//    public void adicionarProduto(Livro livro) {
//        estoqueLivros.adicionarProduto(livro);
//    }
//
//    @Override
//    public void adicionarProduto(Jogo jogo) {
//        estoqueJogos.adicionarProduto(jogo);
//    }
//
//    @Override
//    public void adicionarProduto(Brinquedo brinquedo) {
//        estoqueBrinquedos.adicionarProduto(brinquedo);
//    }
//
//    @Override
//    public void adicionarProduto(Filme filme) {
//        estoqueFilmes.adicionarProduto(filme);
//    }
//
//    @Override
//    public void adicionarProduto(AlbumMusica albumMusica) {
//        estoqueAlbunsMusica.adicionarProduto(albumMusica);
//    }

    @Override
    public void adicionarProduto(Produto produto) {
        for (Estoque estoque : estoques) {
            if (estoque.getTipoProduto().equals(Livro.class) && produto instanceof Livro) {
                estoque.adicionarProduto(produto);
                return;
            } else if (estoque.getTipoProduto().equals(Jogo.class) && produto instanceof Jogo) {
                estoque.adicionarProduto(produto);
                return;
            } else if (estoque.getTipoProduto().equals(Brinquedo.class) && produto instanceof Brinquedo) {
                estoque.adicionarProduto(produto);
                return;
            } else if (estoque.getTipoProduto().equals(Filme.class) && produto instanceof Filme) {
                estoque.adicionarProduto(produto);
                return;
            } else if (estoque.getTipoProduto().equals(AlbumMusica.class) && produto instanceof AlbumMusica) {
                estoque.adicionarProduto(produto);
                return;
            }
        }
        System.err.println("Tipo do produto não identificado, nenhum produto foi adicionado");
    }
}
