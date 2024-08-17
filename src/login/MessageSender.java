package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageSender extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField recipientField;
    private JTextArea messageArea;
    private JButton sendButton;

    public MessageSender() {
        setTitle("Enviar Mensagem");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JPanel recipientPanel = new JPanel(new FlowLayout());
        recipientPanel.add(new JLabel("Destinatário:"));
        recipientField = new JTextField(20);
        recipientPanel.add(recipientField);
        panel.add(recipientPanel);

        JPanel messagePanel = new JPanel(new FlowLayout());
        messagePanel.add(new JLabel("Mensagem:"));
        messageArea = new JTextArea(10, 30);
        messagePanel.add(new JScrollPane(messageArea));
        panel.add(messagePanel);

        sendButton = new JButton("Enviar");
        panel.add(sendButton);

        add(panel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String recipient = recipientField.getText();
        String message = messageArea.getText();

        String query = "INSERT INTO messages (recipient, message) VALUES (?, ?)";
        try (Connection connection = LoginApp.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, recipient);
            statement.setString(2, message);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Mensagem enviada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao enviar mensagem.");
            e.printStackTrace();
        }
    }
}
