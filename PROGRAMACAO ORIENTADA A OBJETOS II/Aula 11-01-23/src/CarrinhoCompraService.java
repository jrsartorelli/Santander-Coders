public interface CarrinhoCompraService {
    void adicionarProduto(Produto produto, int quantidade, CarrinhoCompra carrinhoCompra);
    void removerProduto(Produto produto, CarrinhoCompra carrinhoCompra);
    void removerProduto(Produto produto, int quantidade, CarrinhoCompra carrinhoCompra);
    void listarItensCarrinho(CarrinhoCompra carrinhoCompra);
    int buscarQuantidadeItemCarrinho(Produto produto, CarrinhoCompra carrinhoCompra);
    double comprarProdutosCarrinho(CarrinhoCompra carrinhoCompra);

}
