// VeiculosApp.java
public class VeiculosApp {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Ford", "Focus", 4);
        Moto minhaMoto = new Moto("Honda", "CBR", true);

        System.out.println("Meu carro: " + meuCarro.getMarca() + " " + meuCarro.getModelo());
        System.out.println("Número de portas do carro: " + meuCarro.getNumeroPortas());
        meuCarro.acelerar();

        System.out.println("\nMinha moto: " + minhaMoto.getMarca() + " " + minhaMoto.getModelo());
        System.out.println("A moto tem partida elétrica? " + minhaMoto.temPartidaEletrica());
        minhaMoto.ligarPartidaEletrica();
    }
}
