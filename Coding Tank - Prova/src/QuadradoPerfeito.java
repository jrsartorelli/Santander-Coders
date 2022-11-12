import java.util.Random;
import java.util.Scanner;

public class QuadradoPerfeito {

    public static void main(String[] args) {
        int[][] matriz = montarEPreencherQuadrado();
        //Escreva seu algoritmo aqui
        /*int[][] matriz = {  {20, 6, 7, 17},
                            {9, 15, 14, 12},
                            {13, 11, 10, 16},
                            {8, 18, 19, 5}
        };*/

        int somaLinha = 0;
        int somaColuna = 0;
        int somaDiagonalPrincipal = 0;
        int somaDiagonalSecundaria = 0;
        int[] somasColunas = new int[matriz.length];
        int[] somasLinhas = new int[matriz.length];
        boolean quadradoPerfeito = false;

        for (int linha = 0, diagonalNum1 = matriz.length - 1; linha < matriz.length; linha++, diagonalNum1--) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                somaLinha = somaLinha + matriz[linha][coluna];
                somaColuna = somaColuna + matriz[coluna][linha];
                if(linha == coluna){
                    somaDiagonalPrincipal = somaDiagonalPrincipal + matriz[linha][coluna];
                }
                if(coluna == diagonalNum1){
                    somaDiagonalSecundaria = somaDiagonalSecundaria + matriz[linha][coluna];
                }
            }
            somasColunas[linha] = somaLinha;
            somasLinhas[linha] = somaColuna;
            somaLinha = 0;
            somaColuna = 0;
        }
        for (int index = 0; index < somasLinhas.length; index++) {
            if (somaDiagonalPrincipal == somaDiagonalSecundaria
                    && somaDiagonalPrincipal == somasColunas[index]
                    && somasColunas[index] == somasLinhas[index]) {
                quadradoPerfeito = true;
            } else {
                quadradoPerfeito = false;
                break;
            }
        }
        imprimir(matriz);
        if(quadradoPerfeito){
            System.out.println("Quadrado perfeito.");
        }
        else{
            System.out.println("Quadrado não perfeito.");
        }
    }
    public static int[][] montarEPreencherQuadrado() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o tamanho do quadrado desejado:");
        int tamanho = scanner.nextInt();
        int[][] matriz = new int[tamanho][tamanho];
        for (int linha = 0; linha < matriz.length; linha++) {
            int[] colunas = matriz[linha];
            for (int coluna = 0; coluna < colunas.length; coluna++) {
                int valorAleatorio = random.nextInt(0, 1000);
                colunas[coluna] = valorAleatorio;
            }
        }
        return matriz;
    }
    public static void imprimir(int[][] matriz) {
        for (int linha = 0; linha < matriz.length; linha++) {
            int[] colunas = matriz[linha];
            for (int coluna = 0; coluna < colunas.length; coluna++) {
                int valor = colunas[coluna];
                System.out.print("[" + valor + "]");
            }
            System.out.println();
        }
    }

}
