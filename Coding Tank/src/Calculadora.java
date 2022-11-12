import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        float operando1;
        float operando2;
        float resultado = 0f;
        String operacao;
        String continuaCalculadora;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Informe o primeiro operando:");
            operando1 = sc.nextFloat();
            System.out.println("Informe a operação (+, -, *, /):");
            operacao = sc.next();
            System.out.println("Informe o segundo operando:");
            operando2 = sc.nextFloat();

            switch (operacao) {
                case "+" :
                    resultado = somar(operando1, operando2);
                    break;
                case "-" :
                    resultado = subtrair(operando1, operando2);
                    break;
                case "*" :
                    resultado = multiplicar(operando1, operando2);
                    break;
                case "/" :
                    resultado = dividir(operando1, operando2);
                    break;
                default:
                    System.out.println("Operação incoreta");
            }

            System.out.println("O resultado é  " + resultado);
            System.out.println("Digite 's' para realizar novo cálculo:");
            continuaCalculadora = sc.next();

        } while (continuaCalculadora.equalsIgnoreCase("s"));
    }
    public static float somar(float primeiroNumero, float segundoNumero) {
        return primeiroNumero + segundoNumero;

    }
    public static float subtrair(float primeiroNumero, float segundoNumero) {
        return primeiroNumero - segundoNumero;

    }
    public static float multiplicar(float primeiroNumero, float segundoNumero) {
        return primeiroNumero * segundoNumero;

    }
    public static float dividir(float primeiroNumero, float segundoNumero) {
        return primeiroNumero / segundoNumero;

    }
}
