package login;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginApp {

    // Configurações do banco de dados
    private static final String URL = "jdbc:postgresql://localhost:5432/login_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "minhadeusa";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginUI loginUI = new LoginUI();
            loginUI.setVisible(true);
        });
    }

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
