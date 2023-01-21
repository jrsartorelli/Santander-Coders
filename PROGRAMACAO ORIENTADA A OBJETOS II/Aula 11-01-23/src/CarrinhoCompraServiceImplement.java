import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarrinhoCompraServiceImplement implements CarrinhoCompraService {

    @Override
    public void adicionarProduto(Produto produto, int quantidade, CarrinhoCompra carrinhoCompra) {
        List<ItemCarrinho> listaItensCarrinho = carrinhoCompra.getListaProdutosCarrinho().get(produto.getTipoProduto());
        if (listaItensCarrinho != null) {
            ItemCarrinho itemCarrinho = carrinhoCompra.buscarItemCarrinho(produto);
            if (itemCarrinho != null) {
                itemCarrinho.setQuantidade(itemCarrinho.getQuantidade() + quantidade);
            } else {
                itemCarrinho = new ItemCarrinho(produto, quantidade);
                listaItensCarrinho.add(itemCarrinho);
            }
        } else {
            listaItensCarrinho = new ArrayList<>();
            ItemCarrinho itemCarrinho = new ItemCarrinho(produto, quantidade);
            listaItensCarrinho.add(itemCarrinho);
            carrinhoCompra.getListaProdutosCarrinho().put(produto.getTipoProduto(), listaItensCarrinho);
        }
        produto.decrementarQuantidade(quantidade);
        atualizarValorDescontoCategoria(produto.getTipoProduto(), carrinhoCompra);
        atualizarValorCarrinho(carrinhoCompra);
    }

    @Override
    public void removerProduto(Produto produto, CarrinhoCompra carrinhoCompra) {
        ItemCarrinho itemCarrinho = carrinhoCompra.buscarItemCarrinho(produto);
        if (itemCarrinho != null) {
            produto.setQuantidade(produto.getQuantidade() + itemCarrinho.getQuantidade());
            carrinhoCompra.getListaProdutosCarrinho().get(produto.getTipoProduto()).remove(itemCarrinho);
            if (carrinhoCompra.getListaProdutosCarrinho().get(produto.getTipoProduto()).isEmpty()) {
                carrinhoCompra.getListaProdutosCarrinho().remove(produto.getTipoProduto());
            }
            carrinhoCompra.getValoresDescontosCategoria().remove(produto.getTipoProduto());
            atualizarValorDescontoCategoria(produto.getTipoProduto(), carrinhoCompra);
            atualizarValorCarrinho(carrinhoCompra);
        }
    }

    @Override
    public void removerProduto(Produto produto, int quantidade, CarrinhoCompra carrinhoCompra) {
        ItemCarrinho itemCarrinho = carrinhoCompra.buscarItemCarrinho(produto);
        if (itemCarrinho != null) {
            if (itemCarrinho.getQuantidade() < quantidade) {
                System.out.println("Não é possível remover quantidade maior que disponível no carrinho de compras");
                return;
            } else if (itemCarrinho.getQuantidade() == quantidade) {
                removerProduto(produto, carrinhoCompra);
                return;
            }
            produto.setQuantidade(produto.getQuantidade() + quantidade);
            itemCarrinho.setQuantidade(itemCarrinho.getQuantidade() - quantidade);
            carrinhoCompra.getValoresDescontosCategoria().remove(produto.getTipoProduto());
            atualizarValorDescontoCategoria(produto.getTipoProduto(), carrinhoCompra);
            atualizarValorCarrinho(carrinhoCompra);
        }
    }

    @Override
    public void listarItensCarrinho(CarrinhoCompra carrinhoCompra) {
        Collection<List<ItemCarrinho>> listaCategoria = carrinhoCompra.getListaProdutosCarrinho().values();
        for (List<ItemCarrinho> listaItensCategoria : listaCategoria) {
            listaItensCategoria.forEach(System.out::println);
        }
        for (TipoProduto tipoProduto : carrinhoCompra.getValoresDescontosCategoria().keySet()) {
            System.out.printf("Desconto por Categoria - %s = R$%.2f\n", tipoProduto.toString(),
                    carrinhoCompra.getValoresDescontosCategoria().get(tipoProduto));
        }
        System.out.printf("Valor total dos itens no Carrinho: R$%.2f\n", calcularValorTotalCarrinhoSemDesconto(carrinhoCompra));
        System.out.printf("Valor total do(s) Desconto(s): R$%.2f\n", calcularDescontoTotalCarrinho(carrinhoCompra));
                System.out.printf("Valor total da Compra: R$%.2f\n", carrinhoCompra.getValorTotal());
    }

    @Override
    public int buscarQuantidadeItemCarrinho(Produto produto, CarrinhoCompra carrinhoCompra) {
        ItemCarrinho itemCarrinho = carrinhoCompra.buscarItemCarrinho(produto);
        if (itemCarrinho != null) {
            return itemCarrinho.getQuantidade();
        }
        return 0;
    }

    @Override
    public double comprarProdutosCarrinho(CarrinhoCompra carrinhoCompra) {
        double valorTotalCompra = carrinhoCompra.getValorTotal();
        limparCarrinho(carrinhoCompra);
        return valorTotalCompra;
    }

    public void limparCarrinho(CarrinhoCompra carrinhoCompra) {
        carrinhoCompra.getListaProdutosCarrinho().clear();
        carrinhoCompra.setValorTotal(0);
        carrinhoCompra.getValoresDescontosCategoria().clear();
    }

    public double calcularDescontoCategoria(TipoProduto tipoProduto, double valorTotalCategoria, CarrinhoCompra carrinhoCompra) {
        List<Desconto> listaDescontos = carrinhoCompra.getListaDescontosCategoria().get(tipoProduto);
        double maiorDesconto = 0;
        if (listaDescontos != null) {
            for (Desconto desconto : listaDescontos) {
                double descontoCalculado = desconto.calcularDesconto(valorTotalCategoria);
                if (descontoCalculado > maiorDesconto) {
                    maiorDesconto = descontoCalculado;
                }
            }
        }
        return maiorDesconto;
    }

    public double calcularDescontoTotalCarrinho(CarrinhoCompra carrinhoCompra){
        return calcularValorTotalCarrinhoSemDesconto(carrinhoCompra) - carrinhoCompra.getValorTotal();
    }

    public void atualizarValorCarrinho(CarrinhoCompra carrinhoCompra){
        double valorTotal = 0;
        TipoProduto tipoProduto = null;
        for(List<ItemCarrinho> listaItensCarrinho : carrinhoCompra.getListaProdutosCarrinho().values()){
            for(ItemCarrinho itemCarrinho : listaItensCarrinho){
                Produto produto = itemCarrinho.getProduto();
                tipoProduto = produto.getTipoProduto();
                valorTotal += produto.getPreco() * itemCarrinho.getQuantidade();
            }
            if (carrinhoCompra.getValoresDescontosCategoria() != null && carrinhoCompra.getValoresDescontosCategoria().get(tipoProduto) != null) {
                valorTotal -= carrinhoCompra.getValoresDescontosCategoria().get(tipoProduto);
            }
        }
        carrinhoCompra.setValorTotal(valorTotal);
    }

    public double calcularValorCarrinhoCategoriaSemDesconto(TipoProduto tipoProduto, CarrinhoCompra carrinhoCompra) {
        double valorTotalCategoria = 0;
        List<ItemCarrinho> itensCarrinho = carrinhoCompra.getListaProdutosCarrinho().get(tipoProduto);
        if (itensCarrinho != null) {
            for (ItemCarrinho itemCarrinho : itensCarrinho) {
                valorTotalCategoria += (itemCarrinho.getQuantidade() * itemCarrinho.getProduto().getPreco());
            }
        }
        return valorTotalCategoria;
    }

    public double calcularValorTotalCarrinhoSemDesconto(CarrinhoCompra carrinhoCompra) {
        double valorTotalCarrinhoSemDesconto = 0;
        for (TipoProduto tipoProduto : carrinhoCompra.getListaProdutosCarrinho().keySet()) {
            valorTotalCarrinhoSemDesconto += calcularValorCarrinhoCategoriaSemDesconto(tipoProduto, carrinhoCompra);
        }
        return valorTotalCarrinhoSemDesconto;
    }

    public void atualizarValorDescontoCategoria(TipoProduto tipoProduto, CarrinhoCompra carrinhoCompra) {
        double valorTotalCategoriaSemDesconto = calcularValorCarrinhoCategoriaSemDesconto(tipoProduto, carrinhoCompra);
        if (valorTotalCategoriaSemDesconto > 0) {
            double descontoCategoria = calcularDescontoCategoria(tipoProduto,valorTotalCategoriaSemDesconto, carrinhoCompra);
            carrinhoCompra.getValoresDescontosCategoria().put(tipoProduto, descontoCategoria);
        }
    }
}
