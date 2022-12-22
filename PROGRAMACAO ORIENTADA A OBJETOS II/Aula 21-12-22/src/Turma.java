import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Turma<T extends Aluno> {
    private Professor professor;
    private List<Aluno> alunos = new ArrayList<>();

    public void ordenaLista(){
        Collections.sort(alunos);
    }

    public void adicionarAluno(T t){
        alunos.add(t);
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "professor=" + professor +
                ", alunos=" + alunos +
                '}';
    }
}


