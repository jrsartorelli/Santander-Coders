import java.util.Scanner;
/**
 * Crie a função converterTemperatura(...), onde você deve receber a temperatura atual, a medida atual e a medida final.
 * Após a conversão mostrar na tela o resultado final.
 * Ex:
 * Temperatura atual = 100
 * Medida atual = celsius
 * Medida final = kelvin
 * Output = 373,15
 */
public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float temperaturaAtual;
        String unidadeMedidaAtual;
        String unidadeMedidaFinal;

        temperaturaAtual = leFloatUsuario(sc, "Digite a temperatura: ");
        unidadeMedidaAtual = leStringUsuario(sc, "Digite a unidade de medida (Celsius, Kelvin ou Fahrenheit):");
        unidadeMedidaFinal = leStringUsuario(sc, "Digite a unidade de medida para conversão (Celsius, Kelvin ou Fahrenheit):");
        sc.close();

        if(!unidadeMedidaAtual.equals("celsius") && !unidadeMedidaAtual.equals("kelvin") && !unidadeMedidaAtual.equals("fahrenheit") ||
                !unidadeMedidaFinal.equals("celsius") && !unidadeMedidaFinal.equals("kelvin") && !unidadeMedidaFinal.equals("fahrenheit")){
            System.out.println("Opção de unidade de medida inválida");
        } else if(unidadeMedidaFinal.equals(unidadeMedidaAtual)) {
            System.out.println("Opção de unidade de medida para conversão é a mesma");
        } else {
            converteTemperatura(temperaturaAtual, unidadeMedidaAtual, unidadeMedidaFinal);
        }
    }

    private static void converteTemperatura(float temperaturaAtual, String unidadeMedidaAtual, String unidadeMedidaFinal) {
        float temperaturaFinal = 0;

        switch (unidadeMedidaFinal) {
            case "celsius":
                if(unidadeMedidaAtual.equals("kelvin")){
                    temperaturaFinal = temperaturaAtual - 273.15f;
                    System.out.printf("%.2fK para ", temperaturaAtual);
                }
                if (unidadeMedidaAtual.equals("fahrenheit")) {
                    temperaturaFinal = (temperaturaAtual - 32) * 5 / 9;
                    System.out.printf("%.2fºF para ", temperaturaAtual);
                }
                System.out.printf("Celsius é = %.2fºC", temperaturaFinal);
                break;
            case "kelvin":
                if(unidadeMedidaAtual.equals("celsius")){
                    temperaturaFinal = temperaturaAtual + 273.15f;
                    System.out.printf("%.2fºC para ", temperaturaAtual);
                }
                if (unidadeMedidaAtual.equals("fahrenheit")) {
                    temperaturaFinal = ((temperaturaAtual - 32) * 5 / 9) + 273.15f;
                    System.out.printf("%.2fºF para ", temperaturaAtual);
                }
                System.out.printf("Kelvin é = %.2fK", temperaturaFinal);
                break;
            case "fahrenheit":
                if(unidadeMedidaAtual.equals("celsius")){
                    temperaturaFinal = (temperaturaAtual * 9 / 5) + 32;
                    System.out.printf("%.2fºC para ", temperaturaAtual);
                }
                if (unidadeMedidaAtual.equals("kelvin")) {
                    temperaturaFinal = ((temperaturaAtual - 273.15f) * 9 / 5) + 32;
                    System.out.printf("%.2fK para ", temperaturaAtual);
                }
                System.out.printf("Fahrenheit é = %.2fºF", temperaturaFinal);
                break;
            default:
                break;
        }
    }

    private static float leFloatUsuario(Scanner input, String mensagem) {
        float valorRecebido;
        System.out.print(mensagem);
        valorRecebido = input.nextFloat();
        input.nextLine();
        return valorRecebido;
    }

    private static String leStringUsuario(Scanner input, String mensagem) {
        String valorRecebido;
        System.out.print(mensagem);
        valorRecebido = input.nextLine().toLowerCase();
        return valorRecebido;
    }
}
