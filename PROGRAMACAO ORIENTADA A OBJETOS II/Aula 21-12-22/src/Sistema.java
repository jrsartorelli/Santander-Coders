public class Sistema {
    public static void incluirAlunosTurma(Turma<Aluno> turma, Aluno aluno){
        turma.incluirAluno(aluno);
    }

    public static void main(String[] args) {
        Turma<Aluno> Java = new Turma<>();
        Professor professorJava = new Professor("Kadu");
        Aluno alunoJava1 = new AlunoJava("José");
        Aluno alunoJava2 = new AlunoJava("Victor");
        Aluno alunoJava3 = new AlunoJava("Gabriel");

        Turma<Aluno> JavaScript = new Turma<>();
        Professor professorJavaScript = new Professor("Borges");
        Aluno alunoJS1 = new AlunoJS("Pedro");
        Aluno alunoJS2 = new AlunoJS("Bruna");
        Aluno alunoJS3 = new AlunoJS("Marayah");

        Java.setProfessor(professorJava);
        incluirAlunosTurma(Java, alunoJava1);
        incluirAlunosTurma(Java, alunoJava2);
        incluirAlunosTurma(Java, alunoJava3);

        JavaScript.setProfessor(professorJavaScript);
        incluirAlunosTurma(JavaScript, alunoJS1);
        incluirAlunosTurma(JavaScript, alunoJS2);
        incluirAlunosTurma(JavaScript, alunoJS3);

        Java.ordenaLista();
        JavaScript.ordenaLista();
        System.out.println(Java);
        System.out.println(JavaScript);

    }
}
