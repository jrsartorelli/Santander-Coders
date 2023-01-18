import java.util.List;
import java.util.Map;

public class Brinquedo extends Produto{
    private String tipo;

    public Brinquedo(String nome, Integer id, double preco, int quantidade, boolean publicoAdulto, String tipo) {
        this.setNome(nome);
        this.setId(id);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.setPublicoAdulto(publicoAdulto);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void adicionarProduto(Produto produto, Map<TipoProduto, Estoque> estoques) {
        Estoque<Brinquedo> brinquedoEstoque = estoques.get(TipoProduto.BRINQUEDO);
        brinquedoEstoque.adicionarProduto((Brinquedo) produto);
    }

    @Override
    public String toString() {
        return "Brinquedo{" + super.toString() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}