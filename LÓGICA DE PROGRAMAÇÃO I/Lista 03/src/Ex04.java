import java.util.Scanner;

/**
 * Escreva uma função que recebe o nome de um funcionãrio,
 * seu numero de horas trabalhadas por mês,
 * o valor da hora e calcula o salário anual desse funcionário.
 * (Mostre o valor com 2 casas decimais após o ponto).
 */

public class Ex04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nomeFuncionario;
        int numeroHorasTrabalhadasMes;
        float valorHora;

        System.out.print("Digite o nome do Funcionário: ");
        nomeFuncionario = input.nextLine();
        System.out.print("Digite o numero de horas trabalhadas/mês: ");
        numeroHorasTrabalhadasMes = input.nextInt();
        System.out.print("Digite o valor da hora trabalhada: ");
        valorHora = input.nextFloat();

        input.close();

        calculaSalarioBrutoAnual(nomeFuncionario, numeroHorasTrabalhadasMes, valorHora);
    }

    private static void calculaSalarioBrutoAnual(String nomeFuncionario, int numeroHorastrabalhadasMes, float valorHora){
        float salarioMensal;
        float salarioAnual;
        salarioMensal = numeroHorastrabalhadasMes * valorHora;
        salarioAnual = (salarioMensal * 13) + (salarioMensal / 3);
        System.out.printf("%s, contabilizando 13º e 1/3 de férias, seu salário bruto anual é = R$ %.2f", nomeFuncionario, salarioAnual);
    }
}
