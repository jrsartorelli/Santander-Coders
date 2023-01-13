public interface LivrariaService <T extends Produto>{
//    public void adicionarProduto(Livro livro);
//    public void adicionarProduto(Jogo jogo);
//    public void adicionarProduto(Brinquedo brinquedo);
//    public void adicionarProduto(Filme filme);
//    public void adicionarProduto(AlbumMusica albumMusica);

    public void adicionarProduto(T t);
}
