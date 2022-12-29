import java.util.Comparator;

public class Aluno extends Pessoa implements Comparator<Aluno> {

    private Integer matricula;

    public Aluno(String nome, int matricula) {
        super(nome);
        this.matricula = matricula;
    }

    public Aluno() {}

    @Override
    public int compare(Aluno a1, Aluno a2) {
        return a1.getMatricula().compareTo(a2.getMatricula());
    }

    public Integer getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return super.toString() + " - Matrícula: " + this.matricula;
    }
}
