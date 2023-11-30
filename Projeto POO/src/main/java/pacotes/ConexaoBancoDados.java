package pacotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoBancoDados {

    private static final String URL = "jdbc:mariadb://localhost:3306/poo?useSSL=false";
    private static final String USUARIO_BD = "root";
    private static final String SENHA_BD = "";

    public static Connection obterConexao() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO_BD, SENHA_BD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MariaDB não encontrado!", e);
        }
    }

public static void cadastrarUsuario(Usuario usuario) throws SQLException {
    String sql = obterSQL(usuario);

    try (Connection conexao = ConexaoBancoDados.obterConexao();
         PreparedStatement pstmt = conexao.prepareStatement(sql)) {

        pstmt.setString(1, usuario.getNome());
        pstmt.setString(2, usuario.getEmail());

        if (usuario instanceof Programador) {
            pstmt.setString(3, "Programador");
            pstmt.setDouble(4, 5000); 
            pstmt.setInt(5, 10); 
        } if (usuario instanceof Professor) {
            pstmt.setString(3, "Professor");
            pstmt.setDouble(4, 3000); 
            pstmt.setInt(5, 8); 
        }
	else if (usuario instanceof Desempregado) {
                    pstmt.setString(3, "Desempregado");
 			pstmt.setDouble(4, 0); 
			pstmt.setInt(5, 0);
    }

        pstmt.executeUpdate();
        System.out.println("Usuário cadastrado com sucesso!");
    } catch (SQLException e) {
        System.out.println("Erro ao executar o comando SQL: " + e.getMessage());
    }
}


    private static String obterSQL(Usuario usuario) {
        if (usuario instanceof Programador || usuario instanceof Professor || usuario instanceof Desempregado) {
            return "INSERT INTO usuarios (nome, email, cargo, salario, carga_horaria) VALUES (?, ?, ?, ?, ?)";
        } else {
            throw new IllegalArgumentException("Tipo de usuário desconhecido.");
        }
    }
}
