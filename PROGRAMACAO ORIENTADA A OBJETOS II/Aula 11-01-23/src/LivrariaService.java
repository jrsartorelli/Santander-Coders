public interface LivrariaService <T extends Produto>{

    void adicionarProduto(T t);

    T buscarProduto(Integer id);
    T buscarProduto(String nome);
    T buscarProduto(Integer id, TipoProduto tipoProduto);
    T buscarProduto(String nome, TipoProduto tipoProduto);

    boolean removerProduto(Integer id);
    boolean removerProduto(String nome);
    boolean removerProduto(Integer id, TipoProduto tipoProduto);
    boolean removerProduto(String nome, TipoProduto tipoProduto);

    int buscarQuantidadePorCategoria(TipoProduto tipoProduto);

    void listarItensEstoque();
    void listarItensEstoque(TipoProduto tipoProduto);

    double venderProduto(Produto produto, int quantidade, Comprador comprador);
}
