public class Professor extends Pessoa{

    public Professor(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Professor: " + super.toString();
    }
}
