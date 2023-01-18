public interface LivrariaService <T extends Produto>{

    public void adicionarProduto(T t);

    public T buscarProduto(Integer id);
    public T buscarProduto(String nome);
    public T buscarProduto(Integer id, TipoProduto tipoProduto);
    public T buscarProduto(String nome, TipoProduto tipoProduto);

    public boolean removerProduto(Integer id);
    public boolean removerProduto(String nome);
    public boolean removerProduto(Integer id, TipoProduto tipoProduto);
    public boolean removerProduto(String nome, TipoProduto tipoProduto);

    public int buscarQuantidadePorCategoria(TipoProduto tipoProduto);

    public void listarItensEstoque();
    public void listarItensEstoque(TipoProduto tipoProduto);

    public double venderProduto(Produto produto, int quantidade, Comprador comprador);
}
