import java.util.*;

public class CarrinhoCompra {

    private Map<TipoProduto, List<ItemCarrinho>> listaProdutosCarrinho = new HashMap<>();
    private Map<TipoProduto, List<Desconto>> listaDescontosCategoria = new HashMap<>();
    private Map<TipoProduto, Double> valoresDescontosCategoria = new HashMap<>();
    private final Cliente CLIENTE;
    private double valorTotal;

    public CarrinhoCompra(Cliente cliente) {
        List<Desconto> listaDescontosLivros = new ArrayList<>();
        listaDescontosLivros.add(new Desconto(.15, 200));
        listaDescontosLivros.add(new Desconto(.20, 300));
        listaDescontosCategoria.put(TipoProduto.LIVRO, listaDescontosLivros);
        this.CLIENTE = cliente;
        this.valorTotal = 0;
    }

    public Map<TipoProduto, List<ItemCarrinho>> getListaProdutosCarrinho() {
        return listaProdutosCarrinho;
    }

    public Map<TipoProduto, Double> getValoresDescontosCategoria() {
        return valoresDescontosCategoria;
    }

    public Map<TipoProduto, List<Desconto>> getListaDescontosCategoria() {
        return listaDescontosCategoria;
    }

    public Cliente getCLIENTE() {
        return CLIENTE;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ItemCarrinho buscarItemCarrinho(Produto produto){
        List<ItemCarrinho> listaItensCarrinhoCategoria = listaProdutosCarrinho.get(produto.getTipoProduto());
        if (listaItensCarrinhoCategoria != null) {
            for ( ItemCarrinho itemCarrinho : listaItensCarrinhoCategoria) {
                if (itemCarrinho.getProduto().equals(produto)) {
                    return itemCarrinho;
                }
            }
        }
        return null;
    }
}
