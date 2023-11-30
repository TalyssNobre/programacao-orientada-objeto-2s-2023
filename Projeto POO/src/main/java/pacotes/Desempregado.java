package pacotes;

public class Desempregado extends Usuario {

    private double salario;
    private int cargaHoraria;

    public Desempregado(String nome, String email) {
        super(nome, email, "Desempregado");
        this.salario = 0.0;
        this.cargaHoraria = 0;
    }

    public double getSalario() {
        return salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
}
