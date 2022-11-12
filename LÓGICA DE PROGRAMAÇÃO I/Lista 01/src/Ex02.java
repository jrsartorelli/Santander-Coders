import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome;
        float salario;
        int idade;
        float altura;
        String sexo;

        System.out.print("Digite seu nome: ");
        nome = sc.nextLine();

        System.out.print("Digite seu salario: ");
        salario = sc.nextFloat();

        System.out.print("Digite sua idade: ");
        idade = sc.nextInt();

        System.out.print("Digite sua altura: ");
        altura = sc.nextFloat();
        sc.nextLine();

        System.out.print("Digite seu sexo: ");
        sexo = sc.nextLine();

        sc.close();

        System.out.printf("Seu nome é: %s\n", nome);
        System.out.printf("Seu salario é: R$ %.2f\n", salario);
        System.out.printf("Sua Idade é: %d\n", idade);
        System.out.printf("Sua altura é: %.2f\n", altura);
        System.out.printf("Seu sexo é: %s\n", sexo);
    }
}
