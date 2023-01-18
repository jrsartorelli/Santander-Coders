import java.util.HashMap;
import java.util.Map;

public class LivrariaServiceImplement implements LivrariaService {
    private Map<TipoProduto, Estoque> estoques = new HashMap<>();

    public LivrariaServiceImplement() {
        for (TipoProduto tipoProduto : TipoProduto.values()) {
            Estoque estoque = new Estoque();
            estoques.put(tipoProduto, estoque);
        }
    }

    @Override
    public void adicionarProduto(Produto produto) {
        ((AdicaoProduto)produto).adicionarProduto(produto, estoques);
    }

    @Override
    public Produto buscarProduto(Integer id) {
        for (Estoque estoque : estoques.values()) {
            Produto produto = estoque.buscarProduto(id);
            if (produto != null) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto buscarProduto(String nome) {
        for (Estoque estoque : estoques.values()) {
            Produto produto = estoque.buscarProduto(nome);
            if (produto != null) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto buscarProduto(Integer id, TipoProduto tipoProduto) {
        Estoque estoque = estoques.get(tipoProduto);
        if (estoque != null){
            Produto produto = estoque.buscarProduto(id);
            if (produto != null) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto buscarProduto(String nome, TipoProduto tipoProduto) {
        Estoque estoque = estoques.get(tipoProduto);
        if (estoque != null){
            Produto produto = estoque.buscarProduto(nome);
            if (produto != null) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public boolean removerProduto(Integer id) {
        for (Estoque estoque : estoques.values()) {
            if (estoque.removerProduto(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removerProduto(String nome) {
        for (Estoque estoque : estoques.values()) {
            if (estoque.removerProduto(nome)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removerProduto(Integer id, TipoProduto tipoProduto) {
        Estoque estoque = estoques.get(tipoProduto);
        if (estoque != null){
            return estoque.removerProduto(id);
        }
        return false;
    }

    @Override
    public boolean removerProduto(String nome, TipoProduto tipoProduto) {
        Estoque estoque = estoques.get(tipoProduto);
        if (estoque != null){
            return estoque.removerProduto(nome);
        }
        return false;
    }

    @Override
    public int buscarQuantidadePorCategoria(TipoProduto tipoProduto) {
        Estoque estoque = estoques.get(tipoProduto);
        if (estoque != null){
            return estoque.getProdutos().size();
        }
        return 0;
    }

    @Override
    public void listarItensEstoque() {
        for (Estoque estoque : estoques.values()) {
            estoque.getProdutos().forEach(produto -> System.out.println(produto));
        }
    }

    @Override
    public void listarItensEstoque(TipoProduto tipoProduto) {
        Estoque estoque = estoques.get(tipoProduto);
        if (estoque != null){
            estoque.getProdutos().forEach(produto -> System.out.println(produto));
        }
    }

    @Override
    public double venderProduto(Produto produto, int quantidade, Comprador comprador) {
        return ((VendaProduto)produto).venderProduto(quantidade, comprador);
    }
}
