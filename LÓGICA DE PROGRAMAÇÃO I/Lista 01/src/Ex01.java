import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome;
        int idade;
        String profissao;

        System.out.print("Digite seu nome: ");
        nome = sc.nextLine();

        System.out.print("Digite sua idade: ");
        idade = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite sua Profissão: ");
        profissao = sc.nextLine();

        sc.close();

        System.out.print("Seu nome é: " + nome + "\n");
        System.out.println("Sua idade é: " + idade);
        System.out.printf("Sua Profissão é: %s\n", profissao);
    }
}
