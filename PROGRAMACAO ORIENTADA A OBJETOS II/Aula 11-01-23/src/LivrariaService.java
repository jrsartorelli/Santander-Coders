public interface LivrariaService <T extends Produto>{

    public void adicionarProduto(T t);

    public T buscarProduto(Integer id);
    public T buscarProduto(String nome);
    public T buscarProduto(Integer id, TipoProduto tipoProduto);
    public T buscarProduto(String nome, TipoProduto tipoProduto);


    public void removerProduto(Integer id);
    public boolean removerProduto(String nome);
//    public void removerProduto(T t);
//
////    public int buscarQuantidadeItens(Class tipoProduto);
//
//    public void listarItensEstoque();
////    public void listarItensEstoque(Class categoria);
//
//    public double venderProduto(Integer id, Comprador comprador);
//    public double venderProduto(String nome, Comprador comprador);
//    public double venderProduto(Integer id, int quantidade, Comprador comprador);
//    public double venderProduto(String nome, int quantidade, Comprador comprador);

}
