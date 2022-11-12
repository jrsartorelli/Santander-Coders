import java.util.Scanner;

public class Aula01Parte01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu nome:");
        String nome = sc.nextLine();

        System.out.println("Hello World, " + nome);

        sc.close();

    }
}
