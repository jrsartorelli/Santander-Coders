import java.util.Random;

public class Totalizador {
    public static void main(String[] args) {

        Random random = new Random();
        int[] numeros = {
                random.nextInt(0, 10),
                random.nextInt(0, 10),
                random.nextInt(0, 10),
                random.nextInt(0, 10),
                random.nextInt(0, 10),
                random.nextInt(0, 10),
                random.nextInt(0, 10),
                random.nextInt(0, 10),
                random.nextInt(0, 10),
                random.nextInt(0, 10)};
        int maiorNumero = 0;
        int menorNumero = 10;
        int totalizador = 0;
        float valorMedia;

        for(int i = 0; i < numeros.length; i++) {
            if (numeros[i] > maiorNumero){
                maiorNumero = numeros[i];
            }
            if (numeros[i] < menorNumero) {
                menorNumero = numeros[i];
            }
            totalizador = totalizador + numeros[i];
        }
        valorMedia = (float) totalizador / numeros.length;

        System.out.println("Valor Total = " + totalizador + ", valor médio = " + valorMedia +
                ", maior valor = " + maiorNumero + ", menor valor = " + menorNumero);
    }
}
