package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleManager extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField roleNameField;
    private JButton addRoleButton;

    public RoleManager() {
        setTitle("Gerenciamento de Papéis");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        panel.add(new JLabel("Nome do Papel:"));
        roleNameField = new JTextField();
        panel.add(roleNameField);

        addRoleButton = new JButton("Adicionar Papel");
        panel.add(addRoleButton);

        add(panel);

        addRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRole();
            }
        });
    }

    private void addRole() {
        String roleName = roleNameField.getText();

        String query = "INSERT INTO roles (role_name) VALUES (?)";
        try (Connection connection = LoginApp.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, roleName);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Papel adicionado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar papel.");
            e.printStackTrace();
        }
    }
}
