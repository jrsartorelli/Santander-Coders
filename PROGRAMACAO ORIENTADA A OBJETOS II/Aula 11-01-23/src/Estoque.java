import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public T buscarProduto(Integer id) {
        for (T produto : produtos) {
            if (Objects.equals(produto.getId(), id)) {
                return produto;
            }
        }
        return null;
    }

    public T buscarProduto(String nome) {
        for (T produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    public boolean removerProduto(Integer id) {
        T produtoEncontrado = buscarProduto(id);
        if (produtoEncontrado != null) {
            produtos.remove(produtoEncontrado);
            return true;
        }
        return false;
    }

    public boolean removerProduto(String nome) {
        T produtoEncontrado = buscarProduto(nome);
        if (produtoEncontrado != null) {
            produtos.remove(produtoEncontrado);
            return true;
        }
        return false;
    }

    public Class getTipoProduto() {
        return tipoProduto;
    }
}
