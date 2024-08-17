package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {

    private static final long serialVersionUID = 1L;

    public AdminDashboard() {
        setTitle("DataAdminPro - Painel de Controle");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton manageUsersButton = new JButton("Gerenciar Usuários");
        JButton manageRolesButton = new JButton("Gerenciar Papéis");
        JButton viewLogsButton = new JButton("Visualizar Logs");
        JButton viewStatsButton = new JButton("Dashboard de Estatísticas");
        JButton sendMessageButton = new JButton("Enviar Mensagens");
        JButton dataViewerButton = new JButton("Visualizar Dados");

        panel.add(manageUsersButton);
        panel.add(manageRolesButton);
        panel.add(viewLogsButton);
        panel.add(viewStatsButton);
        panel.add(sendMessageButton);
        panel.add(dataViewerButton);

        add(panel);

        manageUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserManager userManager = new UserManager();
                userManager.setVisible(true);
            }
        });

        manageRolesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoleManager roleManager = new RoleManager();
                roleManager.setVisible(true);
            }
        });

        viewLogsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogViewer logViewer = new LogViewer();
                logViewer.setVisible(true);
            }
        });

        viewStatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticsDashboard statsDashboard = new StatisticsDashboard();
                statsDashboard.setVisible(true);
            }
        });

        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MessageSender messageSender = new MessageSender();
                messageSender.setVisible(true);
            }
        });

        dataViewerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataViewer dataViewer = new DataViewer();
                dataViewer.setVisible(true);
            }
        });
    }
}
