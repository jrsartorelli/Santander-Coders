public class Sistema {
    public static void main(String[] args) {

        LivrariaService livraria = new LivrariaServiceImplement();

        Produto livro1 = new Livro("O Senhor dos Anéis", 1, 49.99, 10,
                new String[]{"Fantasia", "Aventura"}, "J.R.R. Tolkien", "Editora Martins Fontes");
        Produto livro2 = new Livro("Harry Potter e a Pedra Filosofal", 2,39.99, 15,
                new String[]{"Fantasia", "Aventura"}, "J.K. Rowling", "Editora Rocco");
        Produto livro3 = new Livro("A Menina que Roubava Livros", 3, 29.99, 5,
                new String[]{"Ficção", "Drama"}, "Markus Zusak", "Editora Intrínseca");
        Produto filme1 = new Filme("Star Wars: Episódio IV - Uma Nova Esperança", 10, 19.99, 20, "Lucasfilm",
                new String[] {"George Lucas"}, new String[]{"Ficção Científica", "Aventura"} , new String[]{"Gary Kurtz"});
        Produto filme2 = new Filme("The Shawshank Redemption", 11, 14.99, 15, "Castle Rock Entertainment",
                new String[] {"Frank Darabont"}, new String[]{"Drama", "Crime"} , new String[]{"Niki Marvin"});

        livraria.adicionarProduto(livro1);
        livraria.adicionarProduto(livro2);
        livraria.adicionarProduto(livro3);
        livraria.adicionarProduto(filme1);
        livraria.adicionarProduto(filme2);

        //Imprimindo o Livro1
        System.out.println(livraria.buscarProduto(1));

        //Criando nova instância para Livro1 com preço diferente
        //Vai incrementar quantidade, mas não irá alterar o valor
        //Condição para igualdade na comparação -> id e nome
        livro1 = new Livro("O Senhor dos Anéis", 1, 70, 10,
                new String[]{"Fantasia", "Aventura"}, "J.R.R. Tolkien", "Editora Martins Fontes");

        livraria.adicionarProduto(livro1);

        System.out.println(livraria.buscarProduto(1));

        //objeto produto local recebe a referência, portanto qualquer alteração nos dados é refletida no produto do estoque
        Produto produto = livraria.buscarProduto(1);
        produto.setPreco(19.90);
        System.out.println(livraria.buscarProduto(1));

        //remove livro3 por nome
        livraria.removerProduto("A Menina que Roubava Livros");

        produto = livraria.buscarProduto("A Menina que Roubava Livros");
        if(produto == null) {
            System.out.println("Produto não encontrado");
        } else {
            System.out.println(produto);
        }

        //Quantidade de itens de um determinado tipo de Produto
        System.out.println(livraria.buscarQuantidadeItens(Livro.class) + " livros");

        //Listar itens de todos os Estoques
        livraria.listarItensEstoques();

    }
}
