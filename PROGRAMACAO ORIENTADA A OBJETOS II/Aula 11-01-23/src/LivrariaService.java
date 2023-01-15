public interface LivrariaService <T extends Produto>{

    public void adicionarProduto(T t);

    public T buscarProduto(Integer id);
    public T buscarProduto(String nome);

    public void removerProduto(Integer id);
    public void removerProduto(String nome);
    public void removerProduto(T t);


}
