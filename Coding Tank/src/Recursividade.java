import java.util.Scanner;

public class Recursividade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o limite para a multiplicação: ");
        int limite = scanner.nextInt();
        calcularFibonacci(0,1,limite);
    }

    public static void calcularFibonacci (int anterior, int atual, int limite){
        if(anterior < limite){
            System.out.print(anterior + " ");
            calcularFibonacci(atual,atual+anterior,limite );
        }
    }
}
