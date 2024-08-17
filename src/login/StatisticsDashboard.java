package login;

import javax.swing.*;
import java.awt.*;

public class StatisticsDashboard extends JFrame {

    private static final long serialVersionUID = 1L;

    public StatisticsDashboard() {
        setTitle("Dashboard de Estatísticas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Exemplo simples de como você pode exibir estatísticas
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel statsLabel = new JLabel("Estatísticas do Sistema:");
        panel.add(statsLabel);

        JLabel userCountLabel = new JLabel("Número de Usuários: 100"); // Substitua pelos dados reais
        panel.add(userCountLabel);

        JLabel logCountLabel = new JLabel("Número de Logs: 500"); // Substitua pelos dados reais
        panel.add(logCountLabel);

        add(panel);
    }
}
