import java.util.Scanner;

/**
 * (beecrowd) Joaozinho quer calcular e mostrar a quantidade de litros de combustível gastos em uma viagem,
 * ao utilizar um automóvel que faz 12 KM/L.
 * Para isso, ele gostaria que você o auxiliasse através de um simples programa.
 * Para efetuar o cálculo, deve-se fornecer o tempo gasto na viagem (em horas) e
 * a velocidade média durante a mesma (em km/h).
 * Assim, pode-se obter distância percorrida e, em seguida,
 * calcular quantos litros seriam necessários.
 * Mostre o valor com 3 casas decimais após o ponto.
 */
public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float tempoViagem;
        float velocidadeMedia;
        float distanciaPercorrida;
        final float CONSUMO_AUTOMOVEL = 12;
        float litrosNecessariosViagem;

        System.out.print("Informe o tempo total da viagem (em horas, exemplo: 1h30 = 1,5): ");
        tempoViagem = sc.nextFloat();
        System.out.print("Informe a velocidade média da viagem (em km/h): ");
        velocidadeMedia = sc.nextFloat();
        distanciaPercorrida = tempoViagem * velocidadeMedia;
        litrosNecessariosViagem = distanciaPercorrida / CONSUMO_AUTOMOVEL;

        System.out.printf("Para esta viagem serão necessários %.3f litros de combustível.", litrosNecessariosViagem);

    }
}
