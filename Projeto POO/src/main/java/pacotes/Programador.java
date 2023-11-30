package pacotes;

public class Programador extends Usuario {
    private double salario;
    private int cargaHoraria;

    public Programador(String nome, String email) {
        super(nome, email, "Programador");
        this.salario = 5000;
        this.cargaHoraria = 10;
    }

    public double getSalario() {
        return salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
}
