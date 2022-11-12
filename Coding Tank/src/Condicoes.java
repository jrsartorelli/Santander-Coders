import java.util.Scanner;

public class Condicoes {

    public static void main (String[] args) {

        float salario;
        float salarioMinimo = 1212f;
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe seu salário:");
        salario = sc.nextFloat();

        if (salario > salarioMinimo) {
            System.out.println("Seu salário é maior que o salário mínimo!");
        }
        else {
            System.out.println("Seu salário é menor ou igual ao1212 salário mínimo!");
        }

    }
}
