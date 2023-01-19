import java.util.Map;

public class Jogo extends Produto{
    private String distribuidora;
    private String genero;
    private String estudio;

    public Jogo(String nome, Integer id, double preco, int quantidade, boolean publicoAdulto, String distribuidora, String genero, String estudio) {
        this.setNome(nome);
        this.setId(id);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.setPublicoAdulto(publicoAdulto);
        this.setTipoProduto(TipoProduto.JOGO);
        this.distribuidora = distribuidora;
        this.genero = genero;
        this.estudio = estudio;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public String toString() {
        return "Jogo{" + super.toString() +
                ", distribuidora='" + distribuidora + '\'' +
                ", genero='" + genero + '\'' +
                ", estudio='" + estudio + '\'' +
                '}';
    }
}