import java.util.Scanner;
/**
 * Receba X notas e calcule a média.
 * (O usuário vai dizer a quantidade de valores que quer calcular)
 */

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidadeTotalNotas;
        float valorTotalNotas = 0;
        float valorMediaNotas;

        System.out.print("Digite a quantidade total de notas: ");
        quantidadeTotalNotas = sc.nextInt();

        for (int index = 1; index <= quantidadeTotalNotas; index++){
            System.out.print("Entre com a nota " + index + ": ");
            valorTotalNotas = valorTotalNotas + sc.nextFloat();
        }

        sc.close();
        if (quantidadeTotalNotas > 0){
            valorMediaNotas = valorTotalNotas / quantidadeTotalNotas;
            System.out.printf("O valor da média é: %.2f", valorMediaNotas);
        }
        else {
            System.out.println("Valor inválido para a quantidade de notas.");
        }
    }
}
