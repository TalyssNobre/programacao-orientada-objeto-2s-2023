import java.util.Scanner;

/**
 Calculadora Simples Crie um programa Java que funcione como uma calculadora simples. 
 Peça ao usuário para inserir dois números e uma operação (+, -, *, /). Realize a operação escolhida e exiba o resultado.
 */

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double numero2 = scanner.nextDouble();

        System.out.print("Digite a operação que voce deseja: (+, -, *, /): ");
        char operacao = scanner.next().charAt(0);

        double resultado = 0.0;

        switch (operacao) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    System.out.println("Não é possível dividir por zero, para de ser burro po.");
                    return;
                }
                break;
            default:
                System.out.println("Operação inválida, tenta de novo ai!");
                return;
        }

        System.out.println("o Resultado da operação é: " + resultado);

        scanner.close();
    }
}
