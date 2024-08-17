package login;

import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame {

    private static final long serialVersionUID = 1L;

    public WelcomePage() {
        setTitle("Bem-vindo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Bem-vindo ao sistema!", JLabel.CENTER);
        panel.add(welcomeLabel, BorderLayout.CENTER);

        JLabel developerLabel = new JLabel("Desenvolvido por: Sergio H. M.", JLabel.CENTER);
        panel.add(developerLabel, BorderLayout.SOUTH);

        add(panel);
    }
}
