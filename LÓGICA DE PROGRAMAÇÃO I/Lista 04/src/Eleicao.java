import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * Eleições (Utilize o Map<K, V>) - Faça um programa que recebe o nome de 3 candidatos e inicia uma votação (10 votos).
 * Para votar, o eleitor deve escrever o nome do candidato.
 * Caso o eleitor vote em um nome que não existe, deverá ser contabilizado um voto nulo.
 * Ao final da votação, mostre o vencedor da eleição com a porcentagem.
 */
public class Eleicao {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner input = new Scanner(System.in);
        final String VOTO_NULO = "Nulo";
        final int NUMERO_CANDIDATOS = 3;
        final int NUMERO_VOTOS = 10;
        map.put(VOTO_NULO, 0);
        String candidatoVencedor = null;
        String candidatoEmpate = null;
        boolean empate = false;
        float pocentagemCandidato;

        for (int i=0; i < NUMERO_CANDIDATOS; i++){
            String candidato = leStringUsuario(input, "Digite o nome do candidato " + (i+1) + ": ");
            if(!map.containsKey(candidato)){
                map.put(candidato, 0);
            } else {
                System.out.println("Os nomes dos candidatos não podem ser iguais. Reinicie o programa!");
                return;
            }
        }
        for (int i=0; i < NUMERO_VOTOS; i++){
            String candidato = leStringUsuario(input, "Digite o nome do seu candidato para votar: ");
            if(map.containsKey(candidato)){
                int quantidadeVotos = map.get(candidato) + 1;
                map.put(candidato, quantidadeVotos);
            } else {
                int quantidadeVotos = map.get(VOTO_NULO) + 1;
                map.put(VOTO_NULO, quantidadeVotos);
            }
        }
        input.close();

        Set<String> chaves = map.keySet();
        for (String chave : chaves) {
            if (!chave.equals("Nulo")){
                if(candidatoVencedor == null || map.get(chave) > map.get(candidatoVencedor)) {
                    candidatoVencedor = chave;
                    empate = false;
                } else if (map.get(chave).equals(map.get(candidatoVencedor))) {
                    empate = true;
                    candidatoEmpate = chave;
                }
            }
            pocentagemCandidato = (float) (map.get(chave) * 100) / NUMERO_VOTOS;
            System.out.printf("\nVotos %s: %.2f%%", chave, pocentagemCandidato);
        }
        pocentagemCandidato = (float) (map.get(candidatoVencedor) * 100) / NUMERO_VOTOS;
        if(empate){
            System.out.printf("\nOs candidatos %s e %s ficaram empatados com %.2f%% dos votos!", candidatoVencedor, candidatoEmpate, pocentagemCandidato);
        } else {
            System.out.printf("\nO candidato vencedor é %s com %.2f%% dos votos!", candidatoVencedor, pocentagemCandidato);
        }
    }
    private static String leStringUsuario(Scanner input, String mensagem) {
        String valorRecebido;
        System.out.print(mensagem);
        valorRecebido = input.nextLine();
        return valorRecebido;
    }
}
