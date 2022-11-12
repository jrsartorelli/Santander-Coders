import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numero;
        boolean ePar;

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe um número:");
        numero = sc.nextInt();

        ePar = numero % 2 == 0;

        System.out.println(ePar);

    }
}
