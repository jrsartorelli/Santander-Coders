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

    @Override
    public String toString() {
        return "Jogo{" + super.toString() +
                ", distribuidora='" + distribuidora + '\'' +
                ", genero='" + genero + '\'' +
                ", estudio='" + estudio + '\'' +
                '}';
    }
}