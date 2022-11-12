import java.util.Scanner;

public class CadastroPessoa {

    public static void main(String[] args) {
        //nome, renda, idade

        Object[][] pessoas = new Object[10][3];
        Scanner scanner = new Scanner(System.in);

        String acao = "l";
        do {
            System.out.println("Você deseja listar(l) ou cadastrar(c) clientes. Pressine (s) para sair?");
            acao = scanner.nextLine();
            if (acao.equalsIgnoreCase("c")) {
                int posicao = procuraPosicaoVaga(pessoas);
                if (posicao >= 0) {
                    cadastra(pessoas, posicao);
                } else {
                    System.out.println("Não é mais possível cadastrar clientes.");
                    imprimir(pessoas);
                    System.exit(0);
                }
            } else if (acao.equalsIgnoreCase("l")) {
                imprimir(pessoas);
            } else if (acao.equalsIgnoreCase("s")) {
                System.exit(0);
            } else {
                System.out.println("Opção incorreta.");
            }
        } while (true);
    }

    public static void cadastra(Object[][] matriz, int posicao) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Informe a renda do cliente:");
        double renda = scanner.nextDouble();

        System.out.println("Informe a idade do cliente:");
        int idade = scanner.nextInt();

        matriz[posicao][0] = nome;
        matriz[posicao][1] = renda;
        matriz[posicao][2] = idade;
    }

    public static int procuraPosicaoVaga(Object[][] matriz) {
        int posicao = -1;
        for (int index = 0; index < matriz.length; index++) {
            Object[] colunas = matriz[index];
            Object primeiraColuna = colunas[0];
            if (primeiraColuna == null) {
                posicao = index;
                break;
            }
        }
        return posicao;
    }

    public static void imprimir(Object[][] matriz) {
        for (int linha = 0; linha < matriz.length; linha++) {
            Object[] colunas = matriz[linha];
            for (int coluna = 0; coluna < colunas.length; coluna++) {
                Object valor = colunas[coluna];
                System.out.print("[" + valor + "]");
            }
            System.out.println();
        }
    }

}