import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Livro extends Produto {
    private String[] generos;
    private String escritor;
    private String editora;

    public Livro(String nome, Integer id, double preco, int quantidade, boolean publicoAdulto, String[] generos, String escritor, String editora) {
        this.setNome(nome);
        this.setId(id);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.setPublicoAdulto(publicoAdulto);
        this.generos = generos;
        this.escritor = escritor;
        this.editora = editora;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public void adicionarProduto(Produto produto, Map<TipoProduto, Estoque> estoques) {
        Estoque<Livro> livroEstoque = estoques.get(TipoProduto.LIVRO);
        if (livroEstoque == null) {
            livroEstoque = new Estoque<>();
            estoques.put(TipoProduto.LIVRO, livroEstoque);
        }
        livroEstoque.adicionarProduto((Livro) produto);
    }

    @Override
    public String toString() {
        return "Livro{" + super.toString() +
                ", generos=" + Arrays.toString(generos) +
                ", escritor='" + escritor + '\'' +
                ", editora='" + editora + '\'' +
                "} ";
    }
}