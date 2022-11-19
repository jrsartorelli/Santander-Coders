import java.util.Scanner;
/**
 * Crie uma calculadora onde cada operação tem sua propria função.
 * Ex: somar(...), subtrair(...), dividir(...), multiplicar(...)
 */
public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operacao;
        double operando1;
        double operando2;
        double resultado;

        System.out.print("Digite a operação desejada\n" +
                "(Somar, Subtrair, Multiplicar ou Dividir): ");
        operacao = sc.nextLine().toLowerCase();
        System.out.println("Digite o operando 1:");
        operando1 = sc.nextDouble();
        System.out.println("Digite o operando 2:");
        operando2 = sc.nextDouble();
        sc.close();

        switch (operacao){
            case "somar":
                resultado = somar(operando1, operando2);
                System.out.printf("O resultado da expressão %.2f + %.2f = %.2f\n", operando1, operando2, resultado);
                break;
            case "subtrair":
                resultado = subtrair(operando1, operando2);
                System.out.printf("O resultado da expressão %.2f - %.2f = %.2f\n", operando1, operando2, resultado);
                break;
            case "multiplicar":
                resultado = multiplicar(operando1, operando2);
                System.out.printf("O resultado da expressão %.2f * %.2f = %.2f\n", operando1, operando2, resultado);
                break;
            case "dividir":
                if(operando2 == 0){
                    System.out.println("Não é possível a divisão por 0.");
                }
                else {
                    resultado = dividir(operando1, operando2);
                    System.out.printf("O resultado da expressão %.2f / %.2f = %.2f\n", operando1, operando2, resultado);
                }
                break;
            default:
                System.out.println("Opção de operação inválida");
                break;
        }
    }
    private static double somar(double operando1, double operando2){
        return operando1 + operando2;
    }
    private static double subtrair(double operando1, double operando2){
        return operando1 - operando2;
    }
    private static double multiplicar(double operando1, double operando2){
        return operando1 * operando2;
    }
    private static double dividir(double operando1, double operando2){
        return operando1 / operando2;
    }
}
