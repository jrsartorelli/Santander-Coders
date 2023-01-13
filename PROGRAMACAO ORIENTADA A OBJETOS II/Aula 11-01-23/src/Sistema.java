public class Sistema {
    public static void main(String[] args) {
        LivrariaService livraria = new LivrariaServiceImplement();

        Produto produto = new Livro("Java", 100, 3,
                new String[]{"Programação", "TI"}, "Escritor", "Editora");

        livraria.adicionarProduto(produto);

    }
}
