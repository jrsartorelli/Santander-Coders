import java.util.Map;

public interface AdicaoProduto {
    void adicionarProduto(Produto produto, Map<TipoProduto, Estoque> estoques);
}
