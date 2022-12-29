public class Pedagogico {
    private Turma<Aluno> turma;

    public Pedagogico(Turma<Aluno> turma) {
        this.turma = turma;
    }

    public void analisarEvolucaoAcademica(){
        Secretaria.listarAlunosPorMatricula(this.turma);
    }
}
