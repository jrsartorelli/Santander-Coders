import java.util.Map;

public interface RepositorioProduto {
    public void adicionarProduto(Produto produto, Map<TipoProduto, Estoque> estoques);

//    public Produto buscarProduto(Integer id, TipoProduto tipoProduto);

}
