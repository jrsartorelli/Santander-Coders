public class Sistema {
    public static void main(String[] args) {
        LivrariaService livraria = new LivrariaServiceImplement();

        Produto produto = new Livro("Java", 100, 3,
                new String[]{"Programação", "TI"}, "Escritor", "Editora");
        Filme filme = new Filme("Esqueceram de Mim", 20, 2, "MGM",
                new String[]{"Steven Spielberg"}, new String[]{"Comédia"}, new String[]{"Produtores"});

        livraria.adicionarProduto(produto);
        livraria.adicionarProduto(filme);

        Produto produto2 = new Livro("Java", 100, 3,
                new String[]{"Programação", "TI"}, "Escritor", "Editora");
        livraria.adicionarProduto(produto2);

    }
}
