import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Turma<T extends Aluno> {
    private Professor professor;
    private List<T> t = new ArrayList<>();

    public void ordenaLista(){
        Collections.sort(t);
    }

    public void incluirAluno(T t){
        this.t.add(t);
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<T> getT() {
        return t;
    }

    @Override
    public String toString() {
        return "Turma{" +
                professor +
                t +
                '}';
    }
}


