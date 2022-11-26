import java.util.Arrays;
/**
 * Dado um array nums. Definimos uma soma acumulada de um array como nums[i] = soma(nums[0]…nums[i]),
 * ou seja, cada elemento deve ser a soma de todos os elementos anteriores e o atual.
 * Por fim, retorne a array com as somas.
 * Exemplo 01:
 * nums = [1,2,3,4]
 * Output: [1,3,6,10]
 */
public class SomaAcumuladaArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        somaArray(array);
        System.out.println(Arrays.toString(array));
    }
    private static void somaArray(int[] array){
        for(int i=array.length-1; i >=0; i-- ) {
            int valorAcumulado = 0;
            for (int j = 0; j <= i; j++) {
                valorAcumulado += array[j];
            }
            array[i] = valorAcumulado;
        }
    }
}
