import java.util.Scanner;

/**
 *  Dado um inteiro, X, execute as seguintes ações condicionais:
 *  Se X for ímpar, imprima Weird
 *  Se X for par e estiver no intervalo inclusivo de 2 a 5, imprima Not Weird
 *  Se X for par e estiver no intervalo inclusivo de 6 a 20, imprima Weird
 *  Se X for par e maior que 20, imprima Not Weird
 */
public class Ex01 {
    public static void main(String[] args) {
        int x;
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        x = sc.nextInt();
        sc.close();

        if (x % 2 != 0 || (x % 2 == 0 && x >= 6 && x <= 20)){
            System.out.println("Weird");
        }else {
            System.out.println("Not Weird");
        }
    }

}
