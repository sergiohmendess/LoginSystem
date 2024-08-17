package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserManager extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton addUserButton;

    public UserManager() {
        setTitle("Gerenciamento de Usuários");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Usuário:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Senha:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        addUserButton = new JButton("Adicionar Usuário");
        panel.add(addUserButton);

        add(panel);

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });
    }

    private void addUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection connection = LoginApp.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Usuário adicionado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar usuário.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao adicionar usuário.");
        }
    }
}
