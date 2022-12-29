import java.util.Collections;
import java.util.List;

public class Secretaria {

    public static Turma<Aluno> matricular(Professor professor, List<Aluno> alunos) {
        Turma<Aluno> turma = new Turma<>();
        turma.setProfessor(professor);

        for (Aluno aluno : alunos) {
            turma.incluirAluno(aluno);
        }
        return turma;
    }

    private static String getAlunoInfo(Aluno aluno) {
        return aluno.toString();
    }

    public static void listarAlunosPorOrdemAlfabetica(Turma<Aluno> turma) {
        Collections.sort(turma.getAlunos());
        listarAlunos(turma);
    }

    public static void listarAlunosPorMatricula(Turma<Aluno> turma) {
        Collections.sort(turma.getAlunos(), new Aluno());
        listarAlunos(turma);
    }

    public static void listarAlunos(Turma<Aluno> turma){
        List<Aluno> alunos = turma.getAlunos();
        for (Aluno aluno : alunos) {
            System.out.println(getAlunoInfo(aluno));
        }
    }
}

