/**
 * Crie uma função que valida se um número pertence a uma array. *
 * Exemplo 01: *
 * Entrada: Array [1, 3, 5, 7] e número 7
 * Saída: true
 * Exemplo 02:
 * Entrada: Array [2, 4, 6, 8] e número 5
 * Saída: false
 */
public class BuscaArray {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7};
        int numero = 7;
        boolean numeroEncontrado;

        numeroEncontrado = localizaNumeroArray(array, numero);
        System.out.println(numeroEncontrado);
    }

    private static boolean localizaNumeroArray(int[] array, int numero) {
        for (int index = 0; index < array.length; index++) {
            if (numero == array[index]) {
                return true;
            }
        }
        return false;
    }
}
