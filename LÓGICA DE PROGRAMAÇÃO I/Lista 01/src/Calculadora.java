import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float operando1;
        float operando2;
        String operacao;
        float resultado;

        System.out.println("Digite o primeiro operando:");
        operando1 = sc.nextFloat();

        System.out.println("Digite a operacao(+, -, * ou /):");
        operacao = sc.next();

        System.out.println("Digite o segundo operando:");
        operando2 = sc.nextFloat();
        sc.close();

        switch (operacao) {
            case "+":
                resultado = operando1 + operando2;
                System.out.printf("O resultado da expressão %.2f + %.2f = %.2f\n", operando1, operando2, resultado);
                break;
            case "-":
                resultado = operando1 - operando2;
                System.out.printf("O resultado da expressão %.2f - %.2f = %.2f\n", operando1, operando2, resultado);
                break;
            case "*":
                resultado = operando1 * operando2;
                System.out.printf("O resultado da expressão %.2f * %.2f = %.2f\n", operando1, operando2, resultado);
                break;
            case "/":
                resultado = operando1 / operando2;
                System.out.printf("O resultado da expressão %.2f / %.2f = %.2f\n", operando1, operando2, resultado);
                break;
            default:
                System.out.println("valor de operação inválida");
                break;
        }


    }
}
