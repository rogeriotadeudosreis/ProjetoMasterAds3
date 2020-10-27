package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author roger
 */
public class Conexao {

    private static Connection conexao = null;

    private static Connection getConexao() {
        try {
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://192.168.0.12:5432/usuario";
            String usuario = "postgres";
            String password = "1357";

            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, password);

        } catch (ClassNotFoundException erro) {
            erro.printStackTrace();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return conexao;
    }
}
