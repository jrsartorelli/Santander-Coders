public class Sistema {

    public static void incluirAlunoTurma(Turma<Aluno> turma, Aluno aluno){
        turma.incluirAluno(aluno);
    }

    public static void main(String[] args) {
        Turma<Aluno> Java = new Turma<>();
        Professor professorJava = new Professor("Kadu");
        Aluno[] alunosJava = new AlunoJava[]{new AlunoJava("José", 123), new AlunoJava("Victor", 456), new AlunoJava("Gabriel", 789)};

        Turma<Aluno> JavaScript = new Turma<>();
        Professor professorJavaScript = new Professor("Borges");
        Aluno[] alunosJS = new AlunoJS[]{new AlunoJS("Pedro", 223), new AlunoJS("Bruna", 224), new AlunoJS("Marayah", 225)};

        Java.setProfessor(professorJava);
        for (Aluno aluno : alunosJava) {
            incluirAlunoTurma(Java, aluno);
        }

        JavaScript.setProfessor(professorJavaScript);
        for (Aluno aluno : alunosJS) {
            incluirAlunoTurma(JavaScript, aluno);
        }

        Java.ordenaLista();
        JavaScript.ordenaLista();
        System.out.println(Java);
        System.out.println(JavaScript);

    }
}
