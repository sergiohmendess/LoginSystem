package login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogViewer extends JFrame {

    private static final long serialVersionUID = 1L;

    public LogViewer() {
        setTitle("Visualização de Logs");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Data", "Usuário", "Ação"}, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadLogs(model);
    }

    private void loadLogs(DefaultTableModel model) {
        String query = "SELECT id, log_date, username, action FROM logs"; // Ajuste conforme necessário
        try (Connection connection = LoginApp.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String date = resultSet.getString("log_date");
                String username = resultSet.getString("username");
                String action = resultSet.getString("action");
                model.addRow(new Object[]{id, date, username, action});
            }
        } catch (SQLException e) {
            System.err.println("Erro ao carregar logs.");
            e.printStackTrace();
        }
    }
}
