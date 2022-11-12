public class InversaoArray {
    public static void main(String[] args) {
        int[] numeros = {5, 9, 6, 10, 15, 63, 70};
        int numTemp;

        for (int i = 0, j = numeros.length-1; i < numeros.length / 2 ; i++, j--) {
            numTemp = numeros[i];
            numeros[i] = numeros[j];
            numeros[j] = numTemp;
        }

        for(int i = 0; i < numeros.length ; i++){
            System.out.print(numeros[i] + " ");
        }

    }

}
