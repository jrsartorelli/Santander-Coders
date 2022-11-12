public class Questao1 {
    public static void main(String[] args) {
        float salario = 1212.0f;
        String areaAtuacao = "Tecnico";
        switch (areaAtuacao) {
            case "Executiva":
                salario = salario + (salario * 20 / 100);
                break;
            case "Gerência":
                salario = salario + (salario * 22 / 100);
                break;
            case "Coordenação":
                salario = salario + (salario * 25 / 100);
                break;
            case "Tecnico":
                salario = salario + (salario * 28 / 100);
                break;
        }
        System.out.println("O seu novo salário é de R$ " + salario);
    }
}
