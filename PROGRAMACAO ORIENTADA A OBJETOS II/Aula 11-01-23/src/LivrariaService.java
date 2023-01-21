public interface LivrariaService {

    Produto buscarProduto(Integer id);
    Produto buscarProduto(String nome);
    Produto buscarProduto(Integer id, TipoProduto tipoProduto);
    Produto buscarProduto(String nome, TipoProduto tipoProduto);

    boolean removerProduto(Integer id);
    boolean removerProduto(String nome);
    boolean removerProduto(Integer id, TipoProduto tipoProduto);
    boolean removerProduto(String nome, TipoProduto tipoProduto);
    boolean removerProduto(Produto produto);

    int buscarQuantidadePorCategoria(TipoProduto tipoProduto);

    void listarItensEstoque();
    void listarItensEstoque(TipoProduto tipoProduto);

    void adicionarProdutoCarrinho(Produto produto, int quantidade, CarrinhoCompra carrinhoCompra);
    void removerProdutoCarrinho(Produto produto, CarrinhoCompra carrinhoCompra);
    void removerProdutoCarrinho(Produto produto, int quantidade, CarrinhoCompra carrinhoCompra);
    void listarItensCarrinho(CarrinhoCompra carrinhoCompra);

    double comprarProdutosCarrinho(CarrinhoCompra carrinhoCompra);
}
