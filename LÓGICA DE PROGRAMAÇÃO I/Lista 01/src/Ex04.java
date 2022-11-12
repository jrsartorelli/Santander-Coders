import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double areaFigura;

        System.out.println("Qual figura geométrica deseja calcular a área?");
        System.out.println("Digite \"1\" para Retângulo.");
        System.out.println("Digite \"2\" para Triângulo.");
        System.out.println("Digite \"3\" para Círculo.");
        System.out.print("Digite \"4\" para Trapézio: ");
        int opcaoCalculo = sc.nextInt();

        if (opcaoCalculo == 1){
            double ladoA;
            double ladoB;
            System.out.println("Digite o tamanho do primeiro lado do Retângulo:");
            ladoA = sc.nextDouble();
            System.out.println("Digite o tamanho do segundo lado do Retângulo:");
            ladoB = sc.nextDouble();

            areaFigura = ladoA * ladoB;
            System.out.printf("A área do Retângulo é %.2f\n", areaFigura);

        } else if (opcaoCalculo == 2) {
            double base;
            double altura;
            System.out.println("Digite o tamanho da base do Triângulo:");
            base = sc.nextDouble();
            System.out.println("Digite a altura do Triângulo:");
            altura = sc.nextDouble();

            areaFigura = (base * altura) / 2;
            System.out.printf("A área do Triângulo é %.2f\n", areaFigura);

        } else if (opcaoCalculo == 3) {
            double raio;
            System.out.println("Digite o tamanho do raio do Círculo:");
            raio = sc.nextDouble();

            areaFigura = Math.PI * (raio * raio);
            System.out.printf("A área do Círculo é %.2f\n", areaFigura);

        } else if (opcaoCalculo == 4) {
            double baseMaior;
            double baseMenor;
            double altura;
            System.out.println("Digite o tamanho da base maior do Trapézio:");
            baseMaior = sc.nextDouble();
            System.out.println("Digite o tamanho da base menor do Trapézio:");
            baseMenor = sc.nextDouble();
            System.out.println("Digite a altura do Trapézio:");
            altura = sc.nextDouble();

            areaFigura = ((baseMaior + baseMenor) * altura) / 2;
            System.out.printf("A área do Triângulo é %.2f\n", areaFigura);

        }else {
            System.out.println("Opção digitada inválida.");
            System.exit(0);
        }
    }
}
