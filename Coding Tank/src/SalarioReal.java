import java.util.Scanner;

public class SalarioReal {

    public static void main(String[] args) {

        double salarioMensalBruto;
        double salarioAnualBruto;
        double salarioMedioLiquido;
        double valorFGTSAnual;

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe seu salário mensal bruto1:");
        salarioMensalBruto = sc.nextDouble();

        salarioAnualBruto = (salarioMensalBruto * 13) + (salarioMensalBruto / 3);
        valorFGTSAnual = salarioAnualBruto * 0.08;
        salarioMedioLiquido = (salarioAnualBruto + valorFGTSAnual) / 12;

        System.out.println("Seu salário médio real é: " + salarioMedioLiquido);

    }
}
