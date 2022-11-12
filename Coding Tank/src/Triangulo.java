import java.util.Scanner;

public class Triangulo {
    public static void main(String[] args) {

        int numLinhas;

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o número de linhas:");
        numLinhas = sc.nextInt();

        for (int i = numLinhas; i > 0; i--) {
            for (int j = 0; j < i;  j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
