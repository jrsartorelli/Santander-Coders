import java.util.Scanner;

public class Piramide {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o número de linhas:");
        int qtdLinhas = sc.nextInt();

        for (int linha = 1; linha <= qtdLinhas; linha++) {
            for (int coluna = 1; coluna < qtdLinhas*2; coluna++){
                if(coluna <= (qtdLinhas - linha) || coluna >= (qtdLinhas + linha)){
                    System.out.print("-");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}
