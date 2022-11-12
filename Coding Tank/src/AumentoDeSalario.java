import java.util.Scanner;

public class AumentoDeSalario {
    public static void main(String[] args) {

        String nomeFuncionario;
        String cargoFuncionario;
        float percentualAumentoTecnicos = 0.50f;
        float percentualAumentoGerentes = 0.30f;
        float percentualAumentoDemais = 0.20f;
        float salarioAtual;
        float salarioReajustado;

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe seu nome:");
        nomeFuncionario = sc.next();
        System.out.println("Informe sua área de atuação:");
        cargoFuncionario = sc.next();
        System.out.println("Informe seu salário mensal atual:");
        salarioAtual = sc.nextFloat();

        if (cargoFuncionario.equalsIgnoreCase("tecnico")) {
            salarioReajustado = salarioAtual * (1 + percentualAumentoTecnicos);
        } else if (cargoFuncionario.equalsIgnoreCase("gerente")) {
            salarioReajustado = salarioAtual * (1 + percentualAumentoGerentes);
        }
        else {
            salarioReajustado = salarioAtual * (1 + percentualAumentoDemais);
        }

        System.out.println(nomeFuncionario + ", seu salário atualizado é " + salarioReajustado);

    }
}
