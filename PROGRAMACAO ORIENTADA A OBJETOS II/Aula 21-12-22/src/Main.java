import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Professor professorJava = new Professor("Kadu");
        List<Aluno> alunosJava = new ArrayList<>();
        alunosJava.add(new AlunoJava("José", 823));
        alunosJava.add(new AlunoJava("Victor", 456));
        alunosJava.add(new AlunoJava("Gabriel", 789));
        Turma<Aluno> turmaJava = Secretaria.matricular(professorJava, alunosJava);

        Professor professorJavaScript = new Professor("Borges");
        List<Aluno> alunosJS = new ArrayList<>();
        alunosJS.add(new AlunoJS("Pedro", 783));
        alunosJS.add(new AlunoJS("Bruna", 424));
        alunosJS.add(new AlunoJS("Marayah", 325));
        Turma<Aluno> turmaJavaScript = Secretaria.matricular(professorJavaScript, alunosJS);

        Supervisao supervisaoJava = new Supervisao(turmaJava);
        Supervisao supervisaoJavaScript = new Supervisao(turmaJavaScript);

        Pedagogico pedagogicoJava = new Pedagogico(turmaJava);
        Pedagogico pedagogicoJavaScript = new Pedagogico(turmaJavaScript);

        System.out.println("Imprimindo Turma Java por ordem alfabética:");
        supervisaoJava.analisarFrequencia();
        System.out.println("\nImprimindo Turma JavaScript por ordem alfabética:");
        supervisaoJavaScript.analisarFrequencia();
        System.out.println("\nImprimindo Turma Java por ordem de matrícula:");
        pedagogicoJava.analisarEvolucaoAcademica();
        System.out.println("\nImprimindo Turma JavaScript por ordem de matrícula:");
        pedagogicoJavaScript.analisarEvolucaoAcademica();

    }
}
