import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Dado um número encontre o seu fatorial.
 */
public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        long resultado;
        NumberFormat formatacaoInteiro = NumberFormat.getInstance();

        System.out.print("Digite o número para cálculo do fatorial: ");
        numero = sc.nextInt();

        System.out.print(numero + "! = ");
        resultado = calcularFatorial(numero);
        System.out.println(formatacaoInteiro.format(resultado));
    }

    private static long calcularFatorial(int num){
        if (num == 1){
            System.out.print(num + " = ");
            return 1;
        }
        else {
            System.out.print(num + " x ");
            return num * calcularFatorial(num - 1);
        }
    }
}
