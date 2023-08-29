import javax.swing.*;
import javax.swing.text.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private MainWindow mainWindow;

    public GameWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        setTitle("Game Window");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeGameWindow();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(exitButton, BorderLayout.SOUTH);

        add(panel);

        setLocationRelativeTo(null);
    }

    private void closeGameWindow() {
        setVisible(false);
        mainWindow.setVisible(true);
    }
}
