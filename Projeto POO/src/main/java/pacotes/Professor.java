package pacotes;

public class Professor extends Usuario {
    private double salario;
    private int cargaHoraria;

    public Professor(String nome, String email) {
        super(nome, email, "Professor");
        this.salario = 3000;
        this.cargaHoraria = 8;
    }

    public double getSalario() {
        return salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
}
