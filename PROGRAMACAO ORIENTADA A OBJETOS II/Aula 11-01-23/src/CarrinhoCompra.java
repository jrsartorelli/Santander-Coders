import java.util.*;

public class CarrinhoCompra {

    private Map<TipoProduto, List<ItemCarrinho>> listaProdutosCarrinho = new HashMap<>();
    private Map<TipoProduto, List<Desconto>> listaDescontosCategoria = new HashMap<>();
    private Map<TipoProduto, Double> valoresDescontosCategoria = new HashMap<>();
    private Cliente cliente;
    private double valorTotal;

    public CarrinhoCompra(Cliente cliente) {
        List<Desconto> listaDescontosLivros = new ArrayList<>();
        listaDescontosLivros.add(new Desconto(.15, 200));
        listaDescontosCategoria.put(TipoProduto.LIVRO, listaDescontosLivros);
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
