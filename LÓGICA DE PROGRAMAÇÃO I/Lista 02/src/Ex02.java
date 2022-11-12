import java.util.Scanner;
/**
 * Desenvolver uma calculadora que o usuário será capaz de
 * escolher uma das opções abaixo e passar 2 números para o processamento.
 * Somar
 * Subtrair
 * Multiplicar
 * Dividir // não permitir divisão por ZERO
 * Resto
 * Raiz
 * Potência
 */

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operacao;
        double operando1;
        double operando2;
        double resultado;

        System.out.print("Digite a operação desejada\n" +
                "(Somar, Subtrair, Multiplicar, Dividir, Resto, Raiz ou Potência): ");
        operacao = sc.nextLine().toLowerCase();
        System.out.println("Digite o operando 1:");
        operando1 = sc.nextDouble();
        System.out.println("Digite o operando 2:");
        operando2 = sc.nextDouble();
        sc.close();

        switch (operacao){
            case "somar":
                resultado = operando1 + operando2;
                System.out.printf("O resultado da expressão %.2f + %.2f = %.2f\n", operando1, operando2, resultado);
                break;
            case "subtrair":
                resultado = operando1 - operando2;
                System.out.printf("O resultado da expressão %.2f - %.2f = %.2f\n", operando1, operando2, resultado);
                break;
            case "multiplicar":
                resultado = operando1 * operando2;
                System.out.printf("O resultado da expressão %.2f * %.2f = %.2f\n", operando1, operando2, resultado);
                break;
            case "dividir":
                if(operando2 == 0){
                    System.out.println("Não é possível a divisão por 0.");
                }
                else {
                    resultado = operando1 / operando2;
                    System.out.printf("O resultado da expressão %.2f / %.2f = %.2f\n", operando1, operando2, resultado);
                }
                break;
            case "resto":
                resultado = operando1 % operando2;
                System.out.printf("O resto da divisão de %.2f por %.2f = %.2f\n", operando1, operando2, resultado);
                break;
            case "raiz":
                resultado = Math.pow(operando2, 1 / operando1);
                System.out.print("O resultado da raiz " + //ternário apenas para praticar, legibilidade ruim
                        ((operando1 == 2) ? "quadrada" : (operando1 == 3) ? "cúbica" : operando1));
                System.out.printf(" do valor base %.2f = %.2f\n", operando2, resultado);
                break;
            case "potencia", "potência":
                resultado = Math.pow(operando1, operando2);
                System.out.printf("O resultado do valor base: %.2f elevado a potência %.0f = %.2f\n", operando1, operando2, resultado);
                break;
            default:
                System.out.println("Opção de operação inválida");
                break;
        }
    }
}