public class Divida {
    public static void main(String[] args) {
        float valorDivida = 10000f;
        float jurosDivida = 0.025f;
        float valorAplicacao = 1500f;
        float rendimento = 0.04f;
        int numeroMeses = 0;

        while (valorDivida > valorAplicacao) {
            valorDivida = valorDivida * (1 + jurosDivida);
            valorAplicacao = valorAplicacao * (1 + rendimento);

            numeroMeses++;
        }

        System.out.println("Número de meses é: " + numeroMeses);


    }
}
