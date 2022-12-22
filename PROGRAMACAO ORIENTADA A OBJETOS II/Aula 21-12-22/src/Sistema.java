public class Sistema {
    public static void incluirAlunoTurma(Turma<Aluno> turma, Aluno aluno){
        turma.incluirAluno(aluno);
    }

    public static void main(String[] args) {
        Turma<Aluno> Java = new Turma<>();
        Professor professorJava = new Professor("Kadu");
        Aluno[] alunosJava = new AlunoJava[]{new AlunoJava("José"), new AlunoJava("Victor"), new AlunoJava("Gabriel")};

        Turma<Aluno> JavaScript = new Turma<>();
        Professor professorJavaScript = new Professor("Borges");
        Aluno[] alunosJS = new AlunoJS[]{new AlunoJS("Pedro"), new AlunoJS("Bruna"), new AlunoJS("Marayah")};

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
