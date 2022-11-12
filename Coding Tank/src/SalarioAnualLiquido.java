import java.util.Scanner;

public class SalarioAnualLiquido {

    public static void main (String[] args) {

        String nomeFuncionario;
        float salarioBaseMensal;
        float decimoTerceiro;
        float tercaParteFerias;
        float percentagemINSS = 0.075f;
        boolean atingiuTetoINSS = false;
        float valorAnualINSS;
        final float valorTetoINSS = 900f;
        float salarioBrutoAnualSemTercaParteFerias;
        float salarioBrutoAnualTotal;
        float salarioLiquidoAnual;

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe seu nome:");
        nomeFuncionario = sc.next();
        System.out.println("Informe seu salário mensal bruto:");
        salarioBaseMensal = sc.nextFloat();

        decimoTerceiro = salarioBaseMensal;
        tercaParteFerias = salarioBaseMensal / 3;

        if (salarioBaseMensal <= 1212) {
            percentagemINSS = 0.075f;
        } else if (salarioBaseMensal > 1212 && salarioBaseMensal <= 2427.35) {
            percentagemINSS = 0.09f;
        } else if (salarioBaseMensal > 2427.35 && salarioBaseMensal <= 3641.03) {
            percentagemINSS = 0.12f;
        } else if (salarioBaseMensal > 3641.03 && salarioBaseMensal <=  7087.22) {
            percentagemINSS = 0.14f;
            atingiuTetoINSS = false;
        }
        else {
            atingiuTetoINSS = true;
        }

        salarioBrutoAnualSemTercaParteFerias = ((salarioBaseMensal * 12) + decimoTerceiro);

        /*  Em se tratando de ABONO PECUNIÁRIO DE FÉRIAS, inclusive seus reflexos e 1/3,
            não há incidência de INSS, IRRF e FGTS (parte empregado/empresa).
            INSS - Arts. 28, §9º, e, 6 da Lei nº 8.212/91.20 de jul. de 2022
        */
        if (atingiuTetoINSS) {
            valorAnualINSS = 13 * valorTetoINSS;
        }
        else {
            valorAnualINSS = salarioBrutoAnualSemTercaParteFerias * percentagemINSS;
        }

        salarioBrutoAnualTotal = salarioBrutoAnualSemTercaParteFerias + tercaParteFerias;
        salarioLiquidoAnual =  salarioBrutoAnualTotal - valorAnualINSS;

        System.out.println( nomeFuncionario + ", seu salário anual bruto é R$ " + salarioBrutoAnualTotal +
            ", o valor total anual INSS descontado é R$ " + valorAnualINSS +
            (atingiuTetoINSS ? (", com o valor do teto mensal INSS aplicado (R$ 900,00).") : (", com taxa aplicada de " + (percentagemINSS * 100)) + "%."));

        System.out.println("Portanto seu salário anual líquido final é R$ " + salarioLiquidoAnual);
    }
}
