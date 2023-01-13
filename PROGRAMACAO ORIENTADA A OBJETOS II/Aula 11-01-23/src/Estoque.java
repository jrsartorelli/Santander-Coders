import java.util.ArrayList;
import java.util.List;

class Estoque <T extends Produto>{
    private List<T> produtos = new ArrayList<>();
    private Class tipoProduto;

    public Estoque(Class tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public List<T> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(T t){
        if (produtos.contains(t)){
            int indice = produtos.indexOf(t);
            T produto = produtos.get(indice);
            produto.incrementarQuantidade(t.getQuantidade());
        } else {
            produtos.add(t);
        }
    }

    public Class getTipoProduto() {
        return tipoProduto;
    }
}
