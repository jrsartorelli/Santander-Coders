import java.util.ArrayList;
import java.util.Comparator;
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

        System.out.println("Imprimindo Turma Java por ordem alfabética:");
        Supervisao.analisarFrequencia(turmaJava);
        System.out.println("\nImprimindo Turma JavaScript por ordem alfabética:");
        Supervisao.analisarFrequencia(turmaJavaScript);
        System.out.println("\nImprimindo Turma Java por ordem de matrícula:");
        Pedagogico.analisarEvolucaoAcademica(turmaJava);
        System.out.println("\nImprimindo Turma JavaScript por ordem de matrícula:");
        Pedagogico.analisarEvolucaoAcademica(turmaJavaScript);

        //Outra forma de utilizar a ordenação diretamente pelo método sort da Classe List
        System.out.println("\nImprimindo Turma Java por ordem alfabética utilizando método sort de List:");
        turmaJava.getAlunos().sort(Comparator.comparing(Aluno::getNome));
        Secretaria.listarAlunos(turmaJava);
        System.out.println("\nImprimindo Turma JavaScript por ordem alfabética utilizando método sort de List:");
        turmaJavaScript.getAlunos().sort(Comparator.comparing(Aluno::getNome));
        Secretaria.listarAlunos(turmaJavaScript);
        System.out.println("\nImprimindo Turma Java por ordem de matrícula utilizando método sort de List:");
        turmaJava.getAlunos().sort(Comparator.comparing(Aluno::getMatricula));
        Secretaria.listarAlunos(turmaJava);
        System.out.println("\nImprimindo Turma JavaScript por ordem de matrícula utilizando método sort de List:");
        turmaJavaScript.getAlunos().sort(Comparator.comparing(Aluno::getMatricula));
        Secretaria.listarAlunos(turmaJavaScript);


    }
}
