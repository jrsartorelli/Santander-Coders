import java.util.ArrayList;
import java.util.List;

class Estoque <T extends Produto>{
    private List<T> produtos = new ArrayList<>();

    public void adicionarProduto(T t){
        if (produtos.contains(t)){
            int indice = produtos.indexOf(t);
            T produto = produtos.get(indice);
            produto.incrementarQuantidade();
        } else {
            produtos.add(t);
        }
    }
}
