import java.util.Random;

public class EncontrarNumero {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numeros = {random.nextInt(0, 10),
                            random.nextInt(0, 10),
                            random.nextInt(0, 10),
                            random.nextInt(0, 10),
                            random.nextInt(0, 10),
                            random.nextInt(0, 10),
                            random.nextInt(0, 10),
                            random.nextInt(0, 10)};

        boolean encontrou = false;

        for(int i = 0; i < numeros.length; i++) {
            if (numeros[i] == 9){
                System.out.println("Número 9 encontrado na posição " + i + " do array");
                encontrou = true;
            }
        }
        if (!encontrou){
            System.out.println("Número não encontrado");
        }
    }
}
