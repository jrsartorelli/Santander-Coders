public class Sistema {
    public static void incluirAlunosTurma(Turma turma, Aluno aluno){
        turma.adicionarAluno(aluno);
    }

    public static void main(String[] args) {
        Turma Coders = new Turma();
        Professor professor = new Professor("Kadu");
        Aluno aluno1 = new Aluno("José");
        Aluno aluno2 = new AlunoJava("Victor");
        Aluno aluno3 = new AlunoJS("Gabriel");

        Coders.setProfessor(professor);
        Sistema.incluirAlunosTurma(Coders, aluno1);
        Sistema.incluirAlunosTurma(Coders, aluno2);
        Sistema.incluirAlunosTurma(Coders, aluno3);

        System.out.println(Coders);
        Coders.ordenaLista();
        System.out.println(Coders);

    }
}
