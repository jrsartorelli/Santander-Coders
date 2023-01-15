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

    @Override
    public Produto buscarProduto(Integer id) {
        for (Estoque estoque : estoques) {
            Produto produto = estoque.buscarProduto(id);
            if (produto != null) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto buscarProduto(String nome) {
        for (Estoque estoque : estoques) {
            Produto produto = estoque.buscarProduto(nome);
            if (produto != null) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public void removerProduto(Integer id) {
        for (Estoque estoque : estoques) {
            if (estoque.removerProduto(id)) {
                return;
            }
        }
        System.err.println("Produto não encontrado para remoção!");
    }

    @Override
    public void removerProduto(String nome) {
        for (Estoque estoque : estoques) {
            if (estoque.removerProduto(nome)) {
                return;
            }
        }
        System.err.println("Produto não encontrado para remoção!");
    }

    @Override
    public void removerProduto(Produto produto) {
        for (Estoque estoque : estoques) {
            if (estoque.getProdutos().remove(produto)) {
                return;
            }
        }
        System.err.println("Produto não encontrado para remoção!");
    }

    @Override
    public int buscarQuantidadeItens(Class tipoProduto) {
        for (Estoque estoque : estoques) {
            if (estoque.getTipoProduto().equals(tipoProduto)) {
                return estoque.getProdutos().size();
            }
        }
        System.err.println("Tipo do produto não identificado, nenhum produto foi adicionado");
        return 0;
    }

    @Override
    public void listarItensEstoques() {
        for (Estoque estoque : estoques) {
            System.out.println(estoque);
        }
    }
}
