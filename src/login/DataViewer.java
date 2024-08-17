package login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataViewer extends JFrame {

    private static final long serialVersionUID = 1L;

    public DataViewer() {
        setTitle("Visualização de Dados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "Valor"}, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadData(model);
    }

    private void loadData(DefaultTableModel model) {
        String query = "SELECT id, name, value FROM data"; // Ajuste a consulta conforme seu esquema de banco de dados
        try (Connection connection = LoginApp.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String value = resultSet.getString("value");
                model.addRow(new Object[]{id, name, value});
            }
        } catch (SQLException e) {
            System.err.println("Erro ao carregar dados.");
            e.printStackTrace();
        }
    }
}
