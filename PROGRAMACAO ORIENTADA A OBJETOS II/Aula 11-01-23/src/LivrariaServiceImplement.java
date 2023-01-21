import java.util.Map;

public class LivrariaServiceImplement  implements LivrariaService {
    private Map<TipoProduto, Estoque<? extends Produto>> estoques;
    private CarrinhoCompraService carrinhoCompraService;

    public LivrariaServiceImplement(Map<TipoProduto, Estoque<? extends Produto>> estoques) {
        this.estoques = estoques;
        this.carrinhoCompraService = new CarrinhoCompraServiceImplement();
    }

    @Override
    public Produto buscarProduto(Integer id) {
        for (Estoque<? extends Produto> estoque : estoques.values()) {
            Produto produto = estoque.buscarProduto(id);
            if (produto != null) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto buscarProduto(String nome) {
        for (Estoque<? extends Produto> estoque : estoques.values()) {
            Produto produto = estoque.buscarProduto(nome);
            if (produto != null) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto buscarProduto(Integer id, TipoProduto tipoProduto) {
        Estoque<? extends Produto> estoque = estoques.get(tipoProduto);
        if (estoque != null){
            return estoque.buscarProduto(id);
        }
        return null;
    }

    @Override
    public Produto buscarProduto(String nome, TipoProduto tipoProduto) {
        Estoque<? extends Produto> estoque = estoques.get(tipoProduto);
        if (estoque != null){
            return estoque.buscarProduto(nome);
        }
        return null;
    }

    @Override
    public boolean removerProduto(Integer id) {
        for (Estoque<? extends Produto> estoque : estoques.values()) {
            if (estoque.removerProduto(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removerProduto(String nome) {
        for (Estoque<? extends Produto> estoque : estoques.values()) {
            if (estoque.removerProduto(nome)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removerProduto(Integer id, TipoProduto tipoProduto) {
        Estoque<? extends Produto> estoque = estoques.get(tipoProduto);
        if (estoque != null){
            return estoque.removerProduto(id);
        }
        return false;
    }

    @Override
    public boolean removerProduto(String nome, TipoProduto tipoProduto) {
        Estoque<? extends Produto> estoque = estoques.get(tipoProduto);
        if (estoque != null){
            return estoque.removerProduto(nome);
        }
        return false;
    }

    @Override
    public boolean removerProduto(Produto produto) {
        return estoques.get(produto.getTipoProduto()).removerProduto(produto);
    }

    @Override
    public int buscarQuantidadePorCategoria(TipoProduto tipoProduto) {
        Estoque<? extends Produto> estoque = estoques.get(tipoProduto);
        if (estoque != null){
            return estoque.getProdutos().size();
        }
        return 0;
    }

    @Override
    public void listarItensEstoque() {
        for (Estoque<? extends Produto> estoque : estoques.values()) {
            if (estoque != null){
                estoque.getProdutos().forEach(System.out::println);
            }
        }
    }

    @Override
    public void listarItensEstoque(TipoProduto tipoProduto) {
        Estoque<? extends Produto> estoque = estoques.get(tipoProduto);
        if (estoque != null){
            estoque.getProdutos().forEach(System.out::println);
        }
    }

    @Override
    public void adicionarProdutoCarrinho(Produto produto, int quantidade, CarrinhoCompra carrinhoCompra) {
        if (produto.isPublicoAdulto() && !carrinhoCompra.getCLIENTE().isMaiorDeIdade()) {
            System.out.println(carrinhoCompra.getCLIENTE().getNome() + ", você tem apenas " +
                            carrinhoCompra.getCLIENTE().calcularIdade() +
                            " anos de idade e este produto tem venda permitida apenas para maiores de 18 anos");
            System.out.println("Item não incluído em seu carrinho");
            return;
        }
        int quantidadeCarrinho = carrinhoCompraService.buscarQuantidadeItemCarrinho(produto, carrinhoCompra);
        int quantidadeEstoque = estoques.get(produto.getTipoProduto()).buscarProduto(produto.getId()).getQuantidade();
        if (quantidadeEstoque >= quantidadeCarrinho + quantidade) {
            carrinhoCompraService.adicionarProduto(produto, quantidade, carrinhoCompra);
        } else {
            System.out.println("Não há a quantidade total solicitada em estoque para adicionar ao carrinho de compras.");
            System.out.println("Resta(m) " + quantidadeEstoque +
                    " unidade(s) que pode(m) ser adicionada(s) ao carrinho de compras.");
        }
    }

    @Override
    public void removerProdutoCarrinho(Produto produto, CarrinhoCompra carrinhoCompra) {
        carrinhoCompraService.removerProduto(produto, carrinhoCompra);
    }

    @Override
    public void removerProdutoCarrinho(Produto produto, int quantidade, CarrinhoCompra carrinhoCompra) {
        carrinhoCompraService.removerProduto(produto, quantidade, carrinhoCompra);
    }

    @Override
    public void listarItensCarrinho(CarrinhoCompra carrinhoCompra) {
        carrinhoCompraService.listarItensCarrinho(carrinhoCompra);
    }

    @Override
    public double comprarProdutosCarrinho(CarrinhoCompra carrinhoCompra) {
        return carrinhoCompraService.comprarProdutosCarrinho(carrinhoCompra);
    }
}
