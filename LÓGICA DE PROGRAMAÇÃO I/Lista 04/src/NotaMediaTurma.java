/**
 * Dado uma array turma onde cada um dos seus elementos é uma array com as notas de cada um dos alunos,
 * calcule e mostre a média de cada aluno e a média da turma.
 * Exemplo:
 * Turma:
 * [
 * [9, 8, 7, 8],
 * [10, 9, 8, 9],
 * [9, 8, 7, 8]
 * ]
 * Output:
 * Aluno 0 - Média 8,
 * Aluno 1 - Média 9,
 * Aluno 2 - Média 8
 * Média da turma: 8,33
 */
public class NotaMediaTurma {
    public static void main(String[] args) {
        int[][] arrayTurma = {{9, 8, 7, 8},{10, 9, 8, 9},{9, 8, 7, 8}};
        float[] mediaAluno = new float[arrayTurma.length];
        float mediaTurma = 0;

        for (int i=0; i< arrayTurma.length; i++){
            float somaNotaAluno = 0;

            for (int j=0; j < arrayTurma[i].length; j++){
                somaNotaAluno += arrayTurma[i][j];

            }
            mediaAluno[i] = somaNotaAluno/arrayTurma[i].length;
            mediaTurma += mediaAluno[i];
            System.out.println("Aluno " + i + " - Média " + mediaAluno[i]);
        }
        mediaTurma =  mediaTurma / arrayTurma.length;
        System.out.println("Média da Turma: " + mediaTurma);
    }
}