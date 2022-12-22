import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Professor professor;
    private List<Aluno> alunos = new ArrayList<>();

    public <T extends Aluno> void adicionarAluno(T t){
        alunos.add(t);
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "professor=" + professor +
                ", alunos=" + alunos +
                '}';
    }
}


