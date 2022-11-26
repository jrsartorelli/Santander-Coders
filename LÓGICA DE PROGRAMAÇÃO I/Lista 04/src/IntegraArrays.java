import java.util.Arrays;
/**
 * Dado duas arrays A e B, escreva uma função que faça a
 * concatenação das arrays de forma alternada. Obs: Ambas as
 * arrays sempre serão do mesmo tamanho e não nulas.
 * Exemplo 01:
 * A: [1, 2, 3, 4]
 * B: [5, 6, 7, 8]
 * Output: [1, 5, 2, 6, 3, 7, 4, 8]
 */
public class IntegraArrays {
    public static void main(String[] args) {
        int[] arrayA = {1,2,3,4};
        int[] arrayB = {5,6,7,8};
        int[] arrayResultado = new int[arrayA.length + arrayB.length];

        arrayResultado = integraArrays(arrayA, arrayB);

        System.out.println(Arrays.toString(arrayResultado));
    }
    private static int[] integraArrays(int[] arrayA, int[] arrayB){
        int[] arrayTemporario = new int[arrayA.length + arrayB.length];
        for(int i=0, j=0; i < arrayA.length; i++,j+=2 ){
            arrayTemporario[j] = arrayA[i];
            arrayTemporario[j+1] = arrayB[i];
        }
        return arrayTemporario;
    }
}
