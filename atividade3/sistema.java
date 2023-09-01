package atividade3;
/* Talys alexandre nobre uc22101806 */
import java.util.Scanner;

public class sistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        estoque estoque = new estoque();

        while (true) {
            System.out.println("1 - Digite para adicionar objeto");
            System.out.println("2 - Digite para remover objeto");
            System.out.println("3 - Digite para listar objetos");
            System.out.println("4 - Digite para atualizar quantidade");
            System.out.println("5 - Digite para sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome do(s) objeto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade(s): ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    objeto novoObjeto = new objeto(nome, quantidade);
                    estoque.adicionarObjeto(novoObjeto);
                    break;
                case 2:
                    System.out.print("Nome do objeto(s) a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    objeto objetoRemover = null;
                    for (objeto obj : estoque.listarObjetos()) {
                        if (obj.getNome().equals(nomeRemover)) {
                            objetoRemover = obj;
                            break;
                        }
                    }
                    if (objetoRemover != null) {
                        estoque.removerobjeto(objetoRemover);
                        System.out.println("Objeto removido.");
                    } else {
                        System.out.println("Objeto nao encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Objetos no estoque:");
                    for (objeto obj : estoque.listarObjetos()) {
                        System.out.println(obj);
                    }
                    break;
                case 4:
                    System.out.print("Nome do objeto a ser atualizado: ");
                    String nomeAtualizar = scanner.nextLine();
                    objeto objetoAtualizar = null;
                    for (objeto obj : estoque.listarObjetos()) {
                        if (obj.getNome().equals(nomeAtualizar)) {
                            objetoAtualizar = obj;
                            break;
                        }
                    }
                    if (objetoAtualizar != null) {
                        System.out.print("Nova quantidade: ");
                        int novaQuantidade = scanner.nextInt();
                        scanner.nextLine(); 
                        objetoAtualizar.setQuantidade(novaQuantidade);
                        System.out.println("Quantidade atualizada.");
                    } else {
                        System.out.println("Objeto não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção invalida.");
                    break;
            }
        }
    }
}
