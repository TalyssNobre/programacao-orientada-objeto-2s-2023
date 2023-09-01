import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a direção da conversão:");
        System.out.println("1. Celsius para Fahrenheit");
        System.out.println("2. Fahrenheit para Celsius");
        int escolha = scanner.nextInt();
        


        double temperatura;

        switch (escolha) {
            case 1:
                System.out.print("Digita a temperatura em graus Celsius que tu quer ai irmao: ");
                temperatura = scanner.nextDouble();
                double fahrenheit = celsiusParaFahrenheit(temperatura);
                String Celsiusformatado = String.format("%2f",fahrenheit);
                System.out.println("A temperatura em Fahrenheit é: " + fahrenheit);
                break;
            case 2:
                System.out.print("Digita a temperatura em Fahrenheit ai meu nobre: ");
                temperatura = scanner.nextDouble();
                double celsius = fahrenheitParaCelsius(temperatura);
                System.out.println("A temperatura em Celsius é: " + celsius);
                break;
            default:
                System.out.println("Sua escolha é inválida.");
                break;
        }

        scanner.close();
    }
        
    public static double celsiusParaFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static String formatarNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(numero);
    }
}
