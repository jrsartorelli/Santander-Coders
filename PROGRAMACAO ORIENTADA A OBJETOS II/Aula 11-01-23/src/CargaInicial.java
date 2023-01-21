import java.util.HashMap;
import java.util.Map;

public class CargaInicial {
    public static Map<TipoProduto, Estoque<? extends Produto>> inicializarEstoques() {
        Map<TipoProduto, Estoque<? extends Produto>> estoques = new HashMap<>();

        Estoque<Livro> estoqueLivro = new Estoque<>();
        Estoque<Filme> estoqueFilme = new Estoque<>();
        Estoque<Jogo> estoqueJogo = new Estoque<>();
        Estoque<Brinquedo> estoqueBrinquedo = new Estoque<>();
        Estoque<AlbumMusica> estoqueAlbumMusica = new Estoque<>();

        estoques.put(TipoProduto.LIVRO, estoqueLivro);
        estoques.put(TipoProduto.FILME, estoqueFilme);
        estoques.put(TipoProduto.JOGO, estoqueJogo);
        estoques.put(TipoProduto.ALBUM_MUSICA, estoqueBrinquedo);
        estoques.put(TipoProduto.BRINQUEDO, estoqueAlbumMusica);

        estoqueLivro.adicionarProduto(new Livro("O Senhor dos Anéis", 1, 20, 10, true,
                new String[]{"Fantasia", "Aventura"}, "J.R.R. Tolkien", "Editora Martins Fontes"));
        estoqueLivro.adicionarProduto(new Livro("Harry Potter e a Pedra Filosofal", 2,39.99, 15, false,
                new String[]{"Fantasia", "Aventura"}, "J.K. Rowling", "Editora Rocco"));
        estoqueLivro.adicionarProduto(new Livro("A Menina que Roubava Livros", 3, 29.99, 5, false,
                new String[]{"Ficção", "Drama"}, "Markus Zusak", "Editora Intrínseca"));
        estoqueFilme.adicionarProduto(new Filme("Star Wars: Episódio IV - Uma Nova Esperança", 10, 20, 20, false,
                "Lucasfilm", new String[] {"George Lucas"}, new String[]{"Ficção Científica", "Aventura"} , new String[]{"Gary Kurtz"}));
        estoqueFilme.adicionarProduto(new Filme("The Shawshank Redemption", 11, 14.99, 15,false,
                "Castle Rock Entertainment", new String[] {"Frank Darabont"}, new String[]{"Drama", "Crime"} , new String[]{"Niki Marvin"}));
        estoqueJogo.adicionarProduto(new Jogo("God of War", 20, 199.99, 10, true,
                "Sony", "Ação-Aventura", "Santa Monica Studio"));
        estoqueJogo.adicionarProduto(new Jogo("The Last of Us Part II", 21, 259.99, 15, true,
                "Sony", "Ação-Aventura", "Naughty Dog"));
        estoqueBrinquedo.adicionarProduto(new Brinquedo("Boneca Barbie", 30, 49.99, 20, false, "Bonecas"));
        estoqueBrinquedo.adicionarProduto(new Brinquedo("Carrinho Hot Wheels", 31, 29.99, 15, false, "Veículos"));
        estoqueAlbumMusica.adicionarProduto(new AlbumMusica("Album 1", 40, 19.99, 10, false,
                new String[]{"Músico 1", "Músico 2"}, new String[]{"Rock", "Pop"}, new String[]{"Selo 1", "Selo 2"}));
        estoqueAlbumMusica.adicionarProduto(new AlbumMusica("Album 2", 41, 29.99, 15, true,
                new String[]{"Músico 3", "Músico 4", "Músico 5"}, new String[]{"Jazz", "Blues"}, new String[]{"Selo 3"}));
        estoqueAlbumMusica.adicionarProduto(new AlbumMusica("Album 3", 42, 24.99, 20, false,
                new String[]{"Músico 6", "Músico 7", "Músico 8", "Músico 9"}, new String[]{"Funk", "R&B"}, new String[]{"Selo 4", "Selo 5"}));

        return estoques;
    }
}
