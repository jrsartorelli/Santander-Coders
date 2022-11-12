import java.util.Scanner;

public class MatrizDiagonal { public static void main(String[] args) {

    int[][] matriz;
    int tamMatriz;

    Scanner sc = new Scanner(System.in);
    System.out.println("Informe o tamanho da Matriz Quadrada:");
    tamMatriz = sc.nextInt();

    matriz = new int[tamMatriz][tamMatriz];

    for(int linha = 0, diagonalNum1 = matriz[linha].length - 1; linha < matriz.length ; linha++, diagonalNum1--){
        for(int coluna = 0; coluna < matriz[linha].length; coluna++){
            if(coluna == diagonalNum1){
                matriz[linha][coluna] = 1;
            }
            else {
                matriz[linha][coluna] = 0;
            }
        }
    }

    for(int linha = 0; linha < matriz.length ; linha++){
        for(int coluna = 0; coluna < matriz[linha].length; coluna++){
            System.out.print("[" + matriz[linha][coluna] + "]");
        }
        System.out.println();
    }
}
}
