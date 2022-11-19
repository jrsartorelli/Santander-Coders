import java.util.Scanner;
/**
 *
 * Criar um carro com os atributos:
 *  - marca
 *  - ligado
 *  - velocidadeAtual
 *
 * Enquanto o carro estiver ligado deve ser capaz de:
 * - Desligar
 * - Acelerar
 * - Frear
 * - Motrar estado atual
 *
 * Regras:
 * - Só podemos desligar o carro quando ele parar (velocidadeAtual = 0)
 * - Só podemos realizar as ações com o carro ligado
 * - A velocidade máxima do nosso carro é de 100km/h
 * - Não existe velocidade negativa
 * - Acelerar + 10km/h (Aumenta 10)
 * - Frear - 10km/h (Diminui 10)
 *
 */
public class PT7_While_Exercicio {

     public static void main(String[] args) {
     int velocidadeAtual = 0;
     int escolha;
     final int VELOCIDADE_MAXIMA = 100;
     String marca = "Fiat";
     boolean ligado = true;
     Scanner input = new Scanner(System.in);

     while(ligado) {
         System.out.println();
         System.out.println("Escolha uma operação:");
         System.out.println("1 - Acelerar");
         System.out.println("2 - Frear");
         System.out.println("3 - Estado atual");
         System.out.println("0 - Desligar");
         System.out.printf("Operacao: ");
         System.out.println();

         escolha = input.nextInt();

         switch (escolha) {
            case 0:
                if(velocidadeAtual == 0) {
                    System.out.println("Você estacionou o carro!");
                    ligado = false;
                } else {
                    System.out.println("Seu carro ainda está em movimento. Não é possível desligá-lo.");
                }
                break;
            case 1:
                if((velocidadeAtual + 10) >= VELOCIDADE_MAXIMA){
                    velocidadeAtual = VELOCIDADE_MAXIMA;
                } else {
                    velocidadeAtual += 10;
                }
                break;
            case 2:
                if((velocidadeAtual - 10) <= 0){
                    velocidadeAtual = 0;
                } else {
                    velocidadeAtual -= 10;
                }
                break;
            case 3:
                if (velocidadeAtual == 0) {
                    System.out.println("Seu carro está parado.");
                } else {
                    System.out.printf("Sua velocidade atual é %d\n", velocidadeAtual);
                }
                break;
            default:
                System.out.println("Opção inválida!");
         }
     }
     input.close();
     }
}