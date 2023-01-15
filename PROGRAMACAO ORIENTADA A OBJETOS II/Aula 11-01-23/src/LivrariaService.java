public interface LivrariaService <T extends Produto>{

    public void adicionarProduto(T t);

    public T buscarProduto(Integer id);
    public T buscarProduto(String nome);

    public void removerProduto(Integer id);
    public void removerProduto(String nome);
    public void removerProduto(T t);

    public int buscarQuantidadeItens(Class tipoProduto);

    public void listarItensEstoque();
    public void listarItensEstoque(Class categoria);

    public double venderProduto(Integer id);
    public double venderProduto(String nome);
    public double venderProduto(Integer id, int quantidade);
    public double venderProduto(String nome, int quantidade);

}
