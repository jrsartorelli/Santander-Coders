import java.util.HashMap;
import java.util.Map;

public class Sistema {
    public static void main(String[] args) {

        Map<TipoProduto, Estoque<? extends Produto>> estoques = new HashMap<>();
        LivrariaService livraria = new LivrariaServiceImplement(estoques);
        Cliente cliente = new Cliente("João Silva", "12.345.678-9", "123.456.789-10", "15/06/2000");
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra(cliente);
        Caixa caixa = new Caixa();

        Estoque<Livro> estoqueLivro = new Estoque<>();
        Estoque<Filme> estoqueFilme = new Estoque<>();
        Estoque<Jogo> estoqueJogo = new Estoque<>();
        Estoque<Brinquedo> estoqueBrinquedo = new Estoque<>();
        Estoque<AlbumMusica> estoqueAlbumMusica = new Estoque<>();

        estoques.put(TipoProduto.LIVRO, estoqueLivro);
        estoques.put(TipoProduto.FILME, estoqueFilme);
        estoques.put(TipoProduto.JOGO, estoqueJogo);
        estoques.put(TipoProduto.ALBUM_MUSICA, estoqueAlbumMusica);
        estoques.put(TipoProduto.BRINQUEDO, estoqueBrinquedo);

        //Variáveis para uso local
        int quantidade;
        int idProduto;
        String nomeProduto;

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

        //Condição para igualdade na comparação — id e nome
        //Override do método equals na classe Produto
        idProduto = 1;
        nomeProduto = "O Senhor dos Anéis";
        System.out.println("Imprimindo o produto de id: " + idProduto);
        System.out.println(livraria.buscarProduto(idProduto));

        //Adição de nova instância de produto com mesmo id e nome
        //Neste caso não adiciona novo produto, apenas incrementa a quantidade
        Livro livro = new Livro("O Senhor dos Anéis", 1, 49.99, 10, false,
                new String[]{"Fantasia", "Aventura"}, "J.R.R. Tolkien", "Editora Martins Fontes");
        estoqueLivro.adicionarProduto(livro);
        System.out.println("\nAdição de nova instância de produto com mesmo id e nome");
        System.out.println("Imprimindo o produto de id: " + idProduto);
        System.out.println(livraria.buscarProduto(idProduto));

        //Busca produto por nome
        System.out.println("\nBusca produto por nome: " + nomeProduto);
        System.out.println(livraria.buscarProduto(nomeProduto));

        //Busca produto por id e TipoProduto
        idProduto = 20;
        System.out.println("\nBusca produto por id e TipoProduto: " + idProduto + " - " + TipoProduto.JOGO);
        System.out.println(livraria.buscarProduto(idProduto, TipoProduto.JOGO));

        //Busca produto por nome e TipoProduto
        nomeProduto = "Carrinho Hot Wheels";
        System.out.println("\nBusca produto por nome e TipoProduto: " + nomeProduto + " - " + TipoProduto.BRINQUEDO);
        System.out.println(livraria.buscarProduto(nomeProduto, TipoProduto.BRINQUEDO));

        //Variável produto recebe a referência, portanto qualquer alteração nos dados é refletida no produto do estoque
        double novoPrecoProduto = 19.99;
        System.out.println("\nAterando o preço do produto: " + nomeProduto + " - " + TipoProduto.BRINQUEDO +
                " -> R$ " + novoPrecoProduto);
        Produto produto = livraria.buscarProduto(nomeProduto);
        if (produto != null){
            produto.setPreco(novoPrecoProduto);
        }
        System.out.println(livraria.buscarProduto(nomeProduto));

        //Remove produto por nome ou id
        nomeProduto = "A Menina que Roubava Livros";
        System.out.println("\nRemover produto com nome: \"" + nomeProduto + "\"");
        if (livraria.removerProduto(nomeProduto)) {
            System.out.println("Produto com nome \"" + nomeProduto + "\" removido do estoque");
        } else {
            System.out.println("Produto com nome \"" + nomeProduto + "\" não encontrado para remoção!");
        }

        //Tentativa de remoção do produto que já foi removido
        System.out.println("\nRemover produto com nome: \"" + nomeProduto + "\"");
        if (livraria.removerProduto(nomeProduto)) {
            System.out.println("Produto com nome \"" + nomeProduto + "\" removido do estoque");
        } else {
            System.out.println("Produto com nome \"" + nomeProduto + "\" não encontrado para remoção!");
        }

        //Quantidade de itens por categoria de Produto
        System.out.println("\nQuantidade de itens por categoria de Produto");
        for (TipoProduto tipoProduto : TipoProduto.values()) {
            System.out.println(livraria.buscarQuantidadePorCategoria(tipoProduto) + " " + tipoProduto.name());
        }

        //Listar todos os itens dos Estoques
        System.out.println("\nListando todo o estoque:");
        livraria.listarItensEstoque();

        //Listar itens por categoria de Produto
        System.out.println("\nListando itens por categoria de Produto: " + TipoProduto.FILME);
        livraria.listarItensEstoque(TipoProduto.FILME);

        //Adiconando produtos ao carrinho de compras
        nomeProduto = "Carrinho Hot Wheels";
        produto = livraria.buscarProduto(nomeProduto, TipoProduto.BRINQUEDO);
        quantidade = 10;
        System.out.println("\nAdicionando " + quantidade + " itens do produto " + nomeProduto + " no carrinho...");
        livraria.adicionarProdutoCarrinho(produto, quantidade, carrinhoCompra);
        livraria.listarItensCarrinho(carrinhoCompra);
        quantidade = 6;
        System.out.println("\nAdicionando " + quantidade + " itens do produto " + nomeProduto + " no carrinho...");
        livraria.adicionarProdutoCarrinho(produto, quantidade, carrinhoCompra);
        livraria.listarItensCarrinho(carrinhoCompra);
        nomeProduto = "O Senhor dos Anéis";
        produto = livraria.buscarProduto(nomeProduto, TipoProduto.LIVRO);
        quantidade = 8;
        System.out.println("\nAdicionando " + quantidade + " itens do produto " + nomeProduto + " no carrinho...");
        livraria.adicionarProdutoCarrinho(produto, quantidade, carrinhoCompra);
        livraria.listarItensCarrinho(carrinhoCompra);
        quantidade = 2;
        System.out.println("\nAdicionando " + quantidade + " itens do produto " + nomeProduto + " no carrinho...");
        livraria.adicionarProdutoCarrinho(produto, quantidade, carrinhoCompra);
        livraria.listarItensCarrinho(carrinhoCompra);

        //Removendo Item do carrinho
        System.out.println("\nRemovendo o produto " + nomeProduto + " do carrinho...");
        livraria.removerProdutoCarrinho(produto, carrinhoCompra);
        livraria.listarItensCarrinho(carrinhoCompra);

        quantidade = 5;
        nomeProduto = "The Last of Us Part II";
        produto = livraria.buscarProduto(nomeProduto);
        System.out.println("\nAdicionando " + quantidade + " itens do produto " + nomeProduto + " no carrinho...");
        livraria.adicionarProdutoCarrinho(produto, quantidade, carrinhoCompra);
        livraria.listarItensCarrinho(carrinhoCompra);

        nomeProduto = "O Senhor dos Anéis";
        produto = livraria.buscarProduto(nomeProduto, TipoProduto.LIVRO);
        quantidade = 10;
        System.out.println("\nAdicionando " + quantidade + " itens do produto " + nomeProduto + " no carrinho...");
        livraria.adicionarProdutoCarrinho(produto, quantidade, carrinhoCompra);
        livraria.listarItensCarrinho(carrinhoCompra);

        //Removendo Item do carrinho
        nomeProduto = "O Senhor dos Anéis";
        produto = livraria.buscarProduto(nomeProduto, TipoProduto.LIVRO);
        quantidade = 3;
        System.out.println("\nRemovendo " + quantidade + " do produto " + nomeProduto + " do carrinho...");
        livraria.removerProdutoCarrinho(produto, quantidade, carrinhoCompra);
        livraria.listarItensCarrinho(carrinhoCompra);

        produto = livraria.buscarProduto(nomeProduto, TipoProduto.LIVRO);
        quantidade = 8;
        System.out.println("\nRemovendo " + quantidade + " do produto " + nomeProduto + " do carrinho...");
        livraria.removerProdutoCarrinho(produto, quantidade, carrinhoCompra);
        livraria.listarItensCarrinho(carrinhoCompra);

        produto = livraria.buscarProduto(nomeProduto, TipoProduto.LIVRO);
        quantidade = 7;
        System.out.println("\nRemovendo " + quantidade + " do produto " + nomeProduto + " do carrinho...");
        livraria.removerProdutoCarrinho(produto, quantidade, carrinhoCompra);
        livraria.listarItensCarrinho(carrinhoCompra);

        //Processo de finalização da Compra
        System.out.println("\nFinalizando a compra:");
        caixa.adicionarDinheiro(livraria.comprarProdutosCarrinho(carrinhoCompra));
        System.out.printf("Valor em Caixa: %.2f\n", caixa.getSaldo());

        //Listar todos os itens dos Estoques
        System.out.println("\nListando todo o estoque despois da compra finalizada:");
        livraria.listarItensEstoque();

    }
}
