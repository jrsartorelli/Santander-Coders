public abstract class Produto {
    private Integer id;
    private String nome;
    private double preco;
    private int quantidade;
    private boolean publicoAdulto;
    private TipoProduto tipoProduto;

    public int getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isPublicoAdulto() {
        return publicoAdulto;
    }

    public void setPublicoAdulto(boolean publicoAdulto) {
        this.publicoAdulto = publicoAdulto;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public boolean decrementarQuantidade(int quantidade){
        if(this.quantidade >= quantidade){
            this.quantidade -= quantidade;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Produto produto = (Produto) o;
        return (id.equals(produto.id) && nome.equals(produto.nome));
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + String.format("R$%.2f", preco) +
                ", quantidade=" + quantidade +
                ", público adulto=" + (publicoAdulto?"sim":"não");
    }
}
