public class Supervisao {
    private Turma<Aluno> turma;

    public Supervisao(Turma<Aluno> turma) {
        this.turma = turma;
    }

    public void analisarFrequencia(){
        Secretaria.listarAlunosPorOrdemAlfabetica(this.turma);
    }
}
