import java.util.Arrays;

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
        this.setTipoProduto(TipoProduto.LIVRO);
        this.generos = generos;
        this.escritor = escritor;
        this.editora = editora;
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