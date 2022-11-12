import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float imc;

        System.out.println("Digite o seu peso:");
        float peso = sc.nextFloat();

        System.out.println("Digite a sua altura:");
        float altura = sc.nextFloat();

        imc = peso / (altura * altura);

        System.out.printf("Seu IMC é %.2f", imc);

    }
}
