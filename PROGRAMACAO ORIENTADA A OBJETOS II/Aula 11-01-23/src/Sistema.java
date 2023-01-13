public class Sistema {
    public static void main(String[] args) {
        LivrariaService livraria = new LivrariaServiceImplement();

        Livro produto = new Livro("Java", 100, 3,
                new String[]{"Programação", "TI"}, "Escritor", "Editora");

        livraria.adicionarProduto(produto);

    }
}
