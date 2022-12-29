public abstract class Pessoa implements Comparable<Pessoa>{
    private String nome;

    public Pessoa() {}

    @Override
    public int compareTo(Pessoa outraPessoa) {
        return this.nome.compareTo(outraPessoa.nome);
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
