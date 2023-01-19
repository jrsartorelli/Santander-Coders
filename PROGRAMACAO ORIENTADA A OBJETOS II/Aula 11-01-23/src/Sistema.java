public class Sistema {
    public static void main(String[] args) {

        LivrariaService livraria = new LivrariaServiceImplement();
        Caixa caixa = new Caixa();
        Cliente comprador = new Cliente("João Silva", "12.345.678-9", "123.456.789-10", "15/06/2000");

        livraria.adicionarProduto(new Livro("O Senhor dos Anéis", 1, 20, 10, true,
                new String[]{"Fantasia", "Aventura"}, "J.R.R. Tolkien", "Editora Martins Fontes"));
        livraria.adicionarProduto(new Livro("Harry Potter e a Pedra Filosofal", 2,39.99, 15, false,
                new String[]{"Fantasia", "Aventura"}, "J.K. Rowling", "Editora Rocco"));
        livraria.adicionarProduto(new Livro("A Menina que Roubava Livros", 3, 29.99, 5, false,
                new String[]{"Ficção", "Drama"}, "Markus Zusak", "Editora Intrínseca"));
        livraria.adicionarProduto(new Filme("Star Wars: Episódio IV - Uma Nova Esperança", 10, 20, 20, false,
                "Lucasfilm", new String[] {"George Lucas"}, new String[]{"Ficção Científica", "Aventura"} , new String[]{"Gary Kurtz"}));
        livraria.adicionarProduto(new Filme("The Shawshank Redemption", 11, 14.99, 15,false,
                "Castle Rock Entertainment", new String[] {"Frank Darabont"}, new String[]{"Drama", "Crime"} , new String[]{"Niki Marvin"}));
        livraria.adicionarProduto(new Jogo("God of War", 20, 199.99, 10, true,
                "Sony", "Ação-Aventura", "Santa Monica Studio"));
        livraria.adicionarProduto(new Jogo("The Last of Us Part II", 21, 259.99, 15, true,
                "Sony", "Ação-Aventura", "Naughty Dog"));
        livraria.adicionarProduto(new Brinquedo("Boneca Barbie", 30, 49.99, 20, false, "Bonecas"));
        livraria.adicionarProduto(new Brinquedo("Carrinho Hot Wheels", 31, 29.99, 15, false, "Veículos"));
        livraria.adicionarProduto(new AlbumMusica("Album 1", 40, 19.99, 10, false,
                new String[]{"Músico 1", "Músico 2"}, new String[]{"Rock", "Pop"}, new String[]{"Selo 1", "Selo 2"}));
        livraria.adicionarProduto(new AlbumMusica("Album 2", 41, 29.99, 15, true,
                new String[]{"Músico 3", "Músico 4", "Músico 5"}, new String[]{"Jazz", "Blues"}, new String[]{"Selo 3"}));
        livraria.adicionarProduto(new AlbumMusica("Album 3", 42, 24.99, 20, false,
                new String[]{"Músico 6", "Músico 7", "Músico 8", "Músico 9"}, new String[]{"Funk", "R&B"}, new String[]{"Selo 4", "Selo 5"}));

        //Condição para igualdade na comparação — id e nome
        //Override do método equals na classe Produto
        int idProduto = 1;
        String nomeProduto = "O Senhor dos Anéis";
        System.out.println("Imprimindo o produto de id: " + idProduto);
        System.out.println(livraria.buscarProduto(idProduto));

        //Adição de nova instância de produto com mesmo id e nome
        //Neste caso não adiciona novo produto, apenas incrementa a quantidade
        Produto produto = new Livro("O Senhor dos Anéis", 1, 49.99, 10, false,
                new String[]{"Fantasia", "Aventura"}, "J.R.R. Tolkien", "Editora Martins Fontes");
        livraria.adicionarProduto(produto);
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
        produto = livraria.buscarProduto(nomeProduto);
        if (produto != null){
            produto.setPreco(novoPrecoProduto);
        }
        System.out.println(livraria.buscarProduto(nomeProduto, TipoProduto.BRINQUEDO));

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

        //Vender um produto: o produto vendido dever ter a quantidade decrementada
        int quantidadeVenda = 10;
        double dinheiroRecebido;
        nomeProduto = "O Senhor dos Anéis";
        produto = livraria.buscarProduto(nomeProduto);
        System.out.println("\nIniciando o processo de Venda de " + quantidadeVenda + " itens de \"" + nomeProduto + "\"");
        System.out.println("Imprimindo os dados do produto antes da venda: ");
        System.out.println(produto);
        dinheiroRecebido = livraria.venderProduto(produto, quantidadeVenda, comprador);
        System.out.println("Imprimindo os dados do produto após a venda realizada: ");
        System.out.println(produto);
        System.out.printf("Dinheiro recebido da venda = R$%.2f\n", dinheiroRecebido);
        caixa.adicionarDinheiro(dinheiroRecebido);
        System.out.printf("\nValor em caixa = R$%.2f%n\n", caixa.getDinheiro());

    }
}
