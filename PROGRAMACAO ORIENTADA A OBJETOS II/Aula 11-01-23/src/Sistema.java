public class Sistema {
    public static void main(String[] args) {

        LivrariaService livraria = new LivrariaServiceImplement();
        Caixa caixa = new Caixa();
        Comprador comprador = new Comprador("João Silva", "12.345.678-9", "123.456.789-10", "15/06/2005");

        Produto livro1 = new Livro("O Senhor dos Anéis", 1, 49.99, 10, true,
                new String[]{"Fantasia", "Aventura"}, "J.R.R. Tolkien", "Editora Martins Fontes");
        Produto livro2 = new Livro("Harry Potter e a Pedra Filosofal", 2,39.99, 15, false,
                new String[]{"Fantasia", "Aventura"}, "J.K. Rowling", "Editora Rocco");
        Produto livro3 = new Livro("A Menina que Roubava Livros", 3, 29.99, 5, false,
                new String[]{"Ficção", "Drama"}, "Markus Zusak", "Editora Intrínseca");
        Produto filme1 = new Filme("Star Wars: Episódio IV - Uma Nova Esperança", 10, 20, 20, false,
                "Lucasfilm", new String[] {"George Lucas"}, new String[]{"Ficção Científica", "Aventura"} , new String[]{"Gary Kurtz"});
        Produto filme2 = new Filme("The Shawshank Redemption", 11, 14.99, 15,false,
                "Castle Rock Entertainment", new String[] {"Frank Darabont"}, new String[]{"Drama", "Crime"} , new String[]{"Niki Marvin"});
        Produto jogo1 = new Jogo("God of War", 20, 199.99, 10, true,
                "Sony", "Ação-Aventura", "Santa Monica Studio");
        Produto jogo2 = new Jogo("The Last of Us Part II", 21, 259.99, 15, true,
                "Sony", "Ação-Aventura", "Naughty Dog");
        Brinquedo brinquedo1 = new Brinquedo("Boneca Barbie", 30, 49.99, 20, false, "Bonecas");
        Brinquedo brinquedo2 = new Brinquedo("Carrinho Hot Wheels", 31, 29.99, 15, false, "Veículos");
        AlbumMusica album1 = new AlbumMusica("Album 1", 1, 19.99, 10, false,
                new String[]{"Músico 1", "Músico 2"}, new String[]{"Rock", "Pop"}, new String[]{"Selo 1", "Selo 2"});
        AlbumMusica album2 = new AlbumMusica("Album 2", 2, 29.99, 15, true,
                new String[]{"Músico 3", "Músico 4", "Músico 5"}, new String[]{"Jazz", "Blues"}, new String[]{"Selo 3"});
        AlbumMusica album3 = new AlbumMusica("Album 3", 3, 24.99, 20, false,
                new String[]{"Músico 6", "Músico 7", "Músico 8", "Músico 9"}, new String[]{"Funk", "R&B"}, new String[]{"Selo 4", "Selo 5"});

        livraria.adicionarProduto(livro1);
        livraria.adicionarProduto(livro2);
        livraria.adicionarProduto(livro3);
        livraria.adicionarProduto(filme1);
        livraria.adicionarProduto(filme2);
        livraria.adicionarProduto(jogo1);
        livraria.adicionarProduto(jogo2);
        livraria.adicionarProduto(brinquedo1);
        livraria.adicionarProduto(brinquedo2);
        livraria.adicionarProduto(album1);
        livraria.adicionarProduto(album2);
        livraria.adicionarProduto(album3);

        //Imprimindo o livro1
        System.out.println(livraria.buscarProduto(1));

        //Nova instância para livro1 com preço diferente
        //Irá incrementar quantidade, mas não alterará o valor
        //Condição para igualdade na comparação — id e nome
        livro1 = new Livro("O Senhor dos Anéis", 1, 70, 10, false,
                new String[]{"Fantasia", "Aventura"}, "J.R.R. Tolkien", "Editora Martins Fontes");

        //A quantidade será incrementada em 10, preço não será alterado
        livraria.adicionarProduto(livro1);
        System.out.println(livraria.buscarProduto(1));

        //variável produto recebe a referência, portanto qualquer alteração nos dados é refletida no produto do estoque
        Produto produto = livraria.buscarProduto(1);
        produto.setPreco(20);
        System.out.println(livraria.buscarProduto(1));

        //remove livro3 por nome
        livraria.removerProduto("A Menina que Roubava Livros");

        //busca no estoque do produto que acabamos de excluir
        System.out.println("\nBusca por Livro que acabou de ser removido");
        produto = livraria.buscarProduto("A Menina que Roubava Livros");
        if(produto == null) {
            System.out.println("Produto não encontrado");
        } else {
            System.out.println(produto);
        }

        //Quantidade de itens de um determinado tipo de Produto
        System.out.println("\nQuantidade de itens de determinado tipo de Produto");
        System.out.println(livraria.buscarQuantidadeItens(Livro.class) + " livros");
        System.out.println(livraria.buscarQuantidadeItens(Jogo.class) + " jogos");
        System.out.println(livraria.buscarQuantidadeItens(Brinquedo.class) + " brinquedos");
        System.out.println(livraria.buscarQuantidadeItens(Filme.class) + " filmes");
        System.out.println(livraria.buscarQuantidadeItens(AlbumMusica.class) + " álbuns de música");

        //Listar itens de todos os Estoques
        System.out.println("\nListando todo o estoque:");
        livraria.listarItensEstoque();

        //Listar itens por categoria
        System.out.println("\nListando o estoque por categoria: " + Filme.class.getName());
        livraria.listarItensEstoque(Filme.class);

        System.out.println("\nListando o estoque por categoria: " + Livro.class.getName());
        livraria.listarItensEstoque(Livro.class);

        System.out.println("\nListando o estoque por categoria: " + Jogo.class.getName());
        livraria.listarItensEstoque(Jogo.class);

        System.out.println("\nListando o estoque por categoria: " + Brinquedo.class.getName());
        livraria.listarItensEstoque(Brinquedo.class);

        System.out.println("\nListando o estoque por categoria: " + AlbumMusica.class.getName());
        livraria.listarItensEstoque(AlbumMusica.class);

        //Vender um produto: o produto vendido dever ter a quantidade decrementada
        int quantidadeVenda = 10;
        String nomeProduto = "O Senhor dos Anéis";
        System.out.println("\nIniciando o processo de Venda de " + quantidadeVenda + " itens de \"" + nomeProduto + "\"");
        double dinheiroRecebido = livraria.venderProduto(nomeProduto, quantidadeVenda, comprador);
        System.out.printf("Dinheiro recebido da venda = R$%.2f\n", dinheiroRecebido);
        caixa.adicionarDinheiro(dinheiroRecebido);
        System.out.println(String.format("\nValor em caixa = R$%.2f", caixa.getDinheiro()));

        System.out.println(livraria.buscarProduto("O Senhor dos Anéis"));

    }
}
