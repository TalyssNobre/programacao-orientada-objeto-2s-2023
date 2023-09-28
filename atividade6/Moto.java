// Moto.java
public class Moto extends Veiculo {
    private boolean temPartidaEletrica;

    public Moto(String marca, String modelo, boolean temPartidaEletrica) {
        super(marca, modelo);
        this.temPartidaEletrica = temPartidaEletrica;
    }

    public boolean temPartidaEletrica() {
        return temPartidaEletrica;
    }

    public void ligarPartidaEletrica() {
        System.out.println("Ligando a partida eletrica da moto.");
    }
}
