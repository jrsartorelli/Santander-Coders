import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Comprador {
    private String nome;
    private String RG;
    private String CPF;
    private LocalDate dataNascimento;

    public Comprador(String nome, String rg, String cpf, String dataNascimento) {
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

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isMaiorDeIdade(){
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataNascimento, dataAtual);
        return idade.getYears() >= 18;
    }
}
