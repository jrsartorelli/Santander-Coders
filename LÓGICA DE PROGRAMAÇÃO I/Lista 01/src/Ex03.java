import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Móludo 01 - Controle de tempo x funcionários.");
        System.out.println("Digite o ano atual da missão (max 9999): ");
        short anoAtualMissao = sc.nextShort(); // 2 bytes -> -32.768 a 32.767

        System.out.println("Digite a quantidade de funcionários envolvidos (max 100): ");
        byte numeroFuncionarios = sc.nextByte(); // 1 byte -> -128 a 127

        System.out.println("\nMóludo 02 - Controle de distância x velocidade.");
        System.out.println("Digite a distancia que o satélite ficará da Terra (max 2 milhões): ");
        int distanciaSatelite = sc.nextInt(); // 4 bytes -> -2.147.483.648 a 2.147.483.647

        System.out.println("Digite a velocidade máxima (max 30.000 km/h): ");
        short velocidadeMaxima = sc.nextShort(); // 2 bytes -> -32.768 a 32.767

        System.out.println("\nMóludo 03 - Status da missão.");
        System.out.println("Digite o estado da missão (\"true\" se já iniciou ou \"false\" se não): ");
        boolean jaIniciouMissao = sc.nextBoolean(); // 1 bit -> 0 ou 1

        System.out.println("Digite a distância que será percorrida durante a missão em km (max 3 bilhões de km): ");
        long distanciaPercorrida = sc.nextLong(); // 8 bytes -> -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807

        System.out.println("Digite a calibragem das antenas (número racional com precisão de no mínimo 14 casa decimais): ");
        double calibragemAntenas = sc.nextDouble(); // 8 bytes

        System.out.println("\nMóludo 01 - Controle de tempo x funcionários.");
        System.out.println("Ano atual da missão: " + anoAtualMissao);
        System.out.println("Quantidade de funcionários envolvidos: " + numeroFuncionarios);

        System.out.println("\nMóludo 02 - Controle de distância x velocidade.");
        System.out.println("Distancia entre o satélite e a Terra (max 2 milhões): " + distanciaSatelite);
        System.out.println("Velocidade máxima do satélite: " + velocidadeMaxima);

        System.out.println("\nMóludo 03 - Status da missão.");
        System.out.println("Missão iniciada: " + jaIniciouMissao);
        System.out.println("Distância percorrida durante a missão em km: " + distanciaPercorrida);
        System.out.printf("Calibragem das antenas: %.14f", calibragemAntenas);
    }
}
