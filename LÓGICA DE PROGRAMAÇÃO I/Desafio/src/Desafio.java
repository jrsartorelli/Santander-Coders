import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int menorMultlipo;
        System.out.print("Entre com um número inteiro: ");
        numero = sc.nextInt();
        menorMultlipo = menorMultiploPar(numero);
        System.out.println("Menor múltiplo par: " + menorMultlipo);
        sc.close();
    }

    public static int menorMultiploPar(int numero) {
        if(numero%2 == 0){
            return numero;
        }
        else {
            return numero * 2;
        }
    }
}
