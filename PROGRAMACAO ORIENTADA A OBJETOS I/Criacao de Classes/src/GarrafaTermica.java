public class GarrafaTermica {
    private String marca;
    private String cor;
    private double capacidadeTotal; //Capacidade em Litros
    private double capacidadeUtilizada = 0; //Capacidade em Litros
    private double temperaturaInterna = 0; // Temperatura em graus Celsius
    private boolean estaAberta = false;

    public GarrafaTermica(String marca, String cor, double capacidadeTotal) {
        this.marca = marca;
        this.cor = cor;
        this.capacidadeTotal = capacidadeTotal;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(double capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public boolean colocarLiquido(double litros, double temperaturaLitros){
        if (!estaAberta){
            System.out.println("A garrafa está com a tampa fechada!");
            return false;
        } else if (this.capacidadeTotal > (this.capacidadeUtilizada + litros)){
            this.temperaturaInterna = ((this.temperaturaInterna * this.capacidadeUtilizada) + (litros * temperaturaLitros))
                    / (this.capacidadeUtilizada + litros);
            this.capacidadeUtilizada += litros;
            return true;
        } else {
            System.out.printf("A garrafa não comporta a adição de %.2f litros!", litros);
            return false;
        }
    }
    public boolean retirarLiquido(double litros){
        if (!estaAberta){
            System.out.println("A garrafa está com a tampa fechada!");
            return false;
        } else if (this.capacidadeUtilizada > litros){
            this.capacidadeUtilizada -= litros;
            return true;
        } else {
            System.out.printf("A garrafa possui apenas %.2f litros, portanto não é possível retirar %.2f litros!", this.capacidadeUtilizada, litros);
            return false;
        }
    }
    public void abrirGarrafa(){
        this.estaAberta = true;
    }
    public void fecharGarrafa(){
        this.estaAberta = false;
    }
    public double medirTemperatura(){
        return this.temperaturaInterna;
    }

    @Override
    public String toString() {
        return "GarrafaTermica{" +
                "marca='" + marca + '\'' +
                ", cor='" + cor + '\'' +
                ", capacidadeTotal=" + capacidadeTotal +
                ", capacidadeUtilizada=" + capacidadeUtilizada +
                ", temperaturaInterna=" + temperaturaInterna +
                ", estaAberta=" + estaAberta +
                '}';
    }
}