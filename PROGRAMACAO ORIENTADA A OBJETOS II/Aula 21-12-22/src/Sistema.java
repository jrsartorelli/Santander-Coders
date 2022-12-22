public class Sistema {
    public static void incluirAlunosTurma(Turma turma, Aluno aluno){
        turma.adicionarAluno(aluno);
    }

    public static void main(String[] args) {
        Turma Coders = new Turma();
        Professor professor = new Professor();
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();
        Aluno aluno3 = new Aluno();

        Coders.setProfessor(professor);
        Sistema.incluirAlunosTurma(Coders, aluno1);
        Sistema.incluirAlunosTurma(Coders, aluno2);
        Sistema.incluirAlunosTurma(Coders, aluno3);

    }
}
