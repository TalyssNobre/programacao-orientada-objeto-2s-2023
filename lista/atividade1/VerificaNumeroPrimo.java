package atividade1;

/**
 * verificaNumeroPrimo
 */
public class verificaNumeroPrimo {

    public static int verificarNumeroPrimo(Integer n) {
        if (n <= 1) {
            return 0; // Números menores ou iguais a 1 não são primos.
        }

        // Verifica divisibilidade do número por todos os inteiros de 2 até a raiz
        // quadrada de n.
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0; // Se n for divisível por algum número, não é primo.
            }
        }

        return 1; // Se não foi encontrado divisor, n é primo.
    }

    public static void main(String[] args) {
        int numero1 = 11;
        int numero2 = 15;
        int numero3 = 3;

        int resultado1 = verificarNumeroPrimo(numero1);
        int resultado2 = verificarNumeroPrimo(numero2);
        int resultado3 = verificarNumeroPrimo(numero3);

        System.out.println(numero1 + " é primo? " + resultado1);
        System.out.println(numero2 + " é primo? " + resultado2);
        System.out.println(numero3 + " é primo? " + resultado3);
    }
}