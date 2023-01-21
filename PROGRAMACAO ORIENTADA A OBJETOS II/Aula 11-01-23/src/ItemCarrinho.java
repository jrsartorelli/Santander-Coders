public class ItemCarrinho {
    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return  "Categoria = " + produto.getTipoProduto() +
                ",id = " + produto.getId() +
                ",nome = " + produto.getNome() +
                ", preço = " + String.format("R$%.2f", produto.getPreco()) +
                ", quantidade=" + quantidade +
                ", VALOR = " + String.format("R$%.2f", (quantidade * produto.getPreco()));
    }
}
