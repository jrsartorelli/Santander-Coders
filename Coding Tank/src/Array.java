public class Array {
    public static void main(String[] args) {
        String nomes[] = new String[5];
        nomes[0] = "Ricardo";
        nomes[1] = "Willian";
        nomes[2] = "Elias";
        nomes[3] = "Gustavo";
        nomes[4] = "Marcelo";

        for(int i = 0; i < nomes.length; i++) {
            System.out.println("Nome da posição " + i + " do array: " + nomes[i]);
        }
    }
}
