package pacotes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class MenuPrincipal {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            do {
                System.out.println("=== Menu ===");
                System.out.println("1. Cadastrar Programador");
                System.out.println("2. Cadastrar Professor");
                System.out.println("3. Cadastrar Desempregado");
                System.out.println("4. Consultar Banco");
		System.out.println("5. Alterar Banco");
		System.out.println("6. Remover do Banco");
		System.out.println("7. Sair");
                System.out.println("Escolha uma opcao:");

                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, escolha uma opcao valida.");
                    scanner.next();
                }
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        cadastrarProgramador(scanner);
                        break;
                    case 2:
                        cadastrarProfessor(scanner);
                        break;
                    case 3:
                        cadastrarDesempregado(scanner);
                        break;
		    case 4:

    			try {
        		consultarUsuarios();
   			 } catch (SQLException e) {
        		System.out.println("Erro ao consultar o banco de dados: " + e.getMessage());
    			}
   			 break;
			case 5:
    try {
        alterarUsuario(scanner);
    } catch (SQLException e) {
        System.out.println("Erro ao alterar registro: " + e.getMessage());
    }
    break;

			case 6:
    try {
        removerUsuario(scanner);
    } catch (SQLException e) {
        System.out.println("Erro ao remover registro: " + e.getMessage());
    }
    break;


                    case 7:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opcao invalida. Escolha novamente.");
                        break;
                }
            } while (opcao != 7);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

private static void cadastrarProgramador(Scanner scanner) throws SQLException {
    System.out.println("=== Cadastro de Programador ===");
    System.out.println("Digite o nome do programador:");
    String nome = scanner.nextLine();

    System.out.println("Digite o email do programador:");
    String email = scanner.nextLine();

    
    Programador programador = new Programador(nome, email);
    ConexaoBancoDados.cadastrarUsuario(programador);
}

private static void cadastrarProfessor(Scanner scanner) throws SQLException {
    System.out.println("=== Cadastro de Professor ===");
    System.out.println("Digite o nome do professor:");
    String nome = scanner.nextLine();

    System.out.println("Digite o email do professor:");
    String email = scanner.nextLine();

    
    Professor professor = new Professor(nome, email);
    ConexaoBancoDados.cadastrarUsuario(professor);
}

    private static void cadastrarDesempregado(Scanner scanner) throws SQLException {
        System.out.println("=== Cadastro de Desempregado ===");
        System.out.println("Digite o nome do desempregado:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email do desempregado:");
        String email = scanner.nextLine();

        
        Desempregado desempregado = new Desempregado(nome, email);
        ConexaoBancoDados.cadastrarUsuario(desempregado);
    }
private static void consultarUsuarios() throws SQLException {
    try (Connection conexao = ConexaoBancoDados.obterConexao()) {
        String sql = "SELECT id, nome, email, cargo, salario, carga_horaria FROM usuarios";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cargo = rs.getString("cargo");
                double salario = rs.getDouble("salario");
                int cargaHoraria = rs.getInt("carga_horaria");

                
                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Email: " + email);
                System.out.println("Cargo: " + cargo);
                System.out.println("Salario: " + salario);
                System.out.println("Carga Horaria: " + cargaHoraria);
                System.out.println("----------------------");
            }
        }
    }
}


private static void alterarUsuario(Scanner scanner) throws SQLException {
    System.out.println("Digite o ID do usuario que deseja alterar:");
    int numeroRegistro = scanner.nextInt();
    scanner.nextLine(); 

    
    System.out.println("Digite o novo nome:");
    String novoNome = scanner.nextLine();

    System.out.println("Digite o novo email:");
    String novoEmail = scanner.nextLine();

    System.out.println("Digite o novo cargo:");
    String novoCargo = scanner.nextLine();

    System.out.println("Digite o novo salario:");
    double novoSalario = scanner.nextDouble();
    scanner.nextLine(); 

    System.out.println("Digite a nova carga horaria:");
    int novaCargaHoraria = scanner.nextInt();
    scanner.nextLine(); 

    try (Connection conexao = ConexaoBancoDados.obterConexao()) {
        String sql = "UPDATE usuarios SET nome = ?, email = ?, cargo = ?, salario = ?, carga_horaria = ? WHERE id = ?";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, novoNome);
            pstmt.setString(2, novoEmail);
            pstmt.setString(3, novoCargo);
            pstmt.setDouble(4, novoSalario);
            pstmt.setInt(5, novaCargaHoraria);
            pstmt.setInt(6, numeroRegistro);

            int linhasAfetadas = pstmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro atualizado. Verifique o numero do registro.");
            }
        }
    }
}


private static void removerUsuario(Scanner scanner) throws SQLException {
    System.out.println("Digite o ID do usuario que deseja remover:");
    int id = scanner.nextInt();
    scanner.nextLine(); 

    try (Connection conexao = ConexaoBancoDados.obterConexao()) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Usuario removido com sucesso!");
            } else {
                System.out.println("Nenhum usuario encontrado com o ID fornecido.");
            }
        }
    }
}



}