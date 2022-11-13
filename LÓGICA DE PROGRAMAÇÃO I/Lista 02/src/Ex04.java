import java.util.Scanner;
/**
 * Dado um inteiro, X, imprima seus primeiros 10 múltiplos.
 * Cada múltiplo X * i (onde 1 <= i <= 10) deve ser impresso em uma nova linha na forma: X x i = resultado.
 * Exemplo de input - > 2
 * Exemplo de output ->
 * 2 x 1 = 2
 * 2 x 2 = 4
 * 2 x 3 = 6
 * 2 x 4 = 8
 * 2 x 5 = 10
 * 2 x 6 = 12
 * 2 x 7 = 14
 * 2 x 8 = 16
 * 2 x 9 = 18
 * 2 x 10 = 20
 */

public class Ex04 {
    public static void main(String[] args) {
        int inteiro;
        int multiplicador = 1;
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        inteiro = sc.nextInt();
        sc.close();

        while (multiplicador <= 10){
            System.out.printf("%d x %d = %d\n", inteiro, multiplicador, inteiro * multiplicador);
            multiplicador++;
        }
    }
}
