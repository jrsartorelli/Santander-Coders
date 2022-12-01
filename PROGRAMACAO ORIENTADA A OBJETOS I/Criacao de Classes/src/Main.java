public class Main {
    public static void main(String[] args) {
        GarrafaTermica garrafa = new GarrafaTermica("Tramontina", "marrom", 1.5);
        System.out.println(garrafa);
        garrafa.colocarLiquido(2, 100);

    }
}
