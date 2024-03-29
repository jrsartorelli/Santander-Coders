import java.util.Arrays;

public class Filme extends Produto{
    private String estudio;
    private String[] diretores;
    private String[] generos;
    private String[] produtores;


    public Filme(String nome, Integer id, double preco, int quantidade, boolean publicoAdulto, String estudio, String[] diretores, String[] generos, String[] produtores) {
        this.setNome(nome);
        this.setId(id);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.setPublicoAdulto(publicoAdulto);
        this.setTipoProduto(TipoProduto.FILME);
        this.estudio = estudio;
        this.diretores = diretores;
        this.generos = generos;
        this.produtores = produtores;
    }

    @Override
    public String toString() {
        return "Filme{" + super.toString() +
                ", estudio='" + estudio + '\'' +
                ", diretores=" + Arrays.toString(diretores) +
                ", generos=" + Arrays.toString(generos) +
                ", produtores=" + Arrays.toString(produtores) +
                '}';
    }
}