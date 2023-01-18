import java.util.Map;

public interface AdicaoProduto {
    public void adicionarProduto(Produto produto, Map<TipoProduto, Estoque> estoques);

}
