public class AlunoJava extends Aluno {

    public AlunoJava(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "AlunoJava: " + super.toString();
    }
}
