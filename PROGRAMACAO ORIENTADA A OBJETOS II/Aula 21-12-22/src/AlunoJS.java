public class AlunoJS extends Aluno{

    public AlunoJS(String nome, Integer matricula) {
        super(nome, matricula);
    }

    @Override
    public String toString() {
        return "AlunoJS: " + super.toString();
    }
}
