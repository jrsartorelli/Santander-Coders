import java.util.Scanner;

public class Balada {
    public static void main(String[] args) {
        int idade;
        String acompanhado;
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a sua idade: ");
        idade =  sc.nextInt();
        sc.nextLine();

        if (idade < 16) {
            System.out.println("Vá pra casa, hora de criança estar na cama!");
        }
        else if (idade < 18 && idade >= 16) {
            System.out.print("Você está acompanhado(sim ou não)? ");
            acompanhado = sc.nextLine();
            sc.close();
            if (!acompanhado.equalsIgnoreCase("sim")) {
                System.out.println("Você não está acompanhado, portanto não pode entrar.");
            }else {
                System.out.println("Você está acompanhado, portanto pode entrar.");
            }
        }else {
            System.out.println("Você pode entrar.");
        }
    }
}
