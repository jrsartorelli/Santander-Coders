import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Cliente {
    private String nome;
    private String RG;
    private String CPF;
    private LocalDate dataNascimento;

    public Cliente(String nome, String rg, String cpf, String dataNascimento) {
        this.nome = nome;
        this.RG = rg;
        this.CPF = cpf;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMaiorDeIdade(){
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataNascimento, dataAtual);
        return idade.getYears() >= 18;
    }

    public int calcularIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataNascimento, dataAtual);
        return idade.getYears();
    }

    @Override
    public String toString() {
        return "Cliente: " + nome +
                ", Idade: " + this.calcularIdade() + " anos";
    }
}
