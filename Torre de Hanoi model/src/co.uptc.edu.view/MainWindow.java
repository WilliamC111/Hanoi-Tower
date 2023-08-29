import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Main Window");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setIconImage(new ImageIcon("img/icon.png").getImage());

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGameWindow();
            }
        });



        playButton.setBackground(Color.DARK_GRAY);
        playButton.setForeground(Color.WHITE);
        playButton.setFocusPainted(false);
        playButton.setBorder(new RoundedBorder(15));


        JPanel panel = new JPanel();
        panel.add(playButton);
        add(panel);

        setLocationRelativeTo(null);
    }

    private void openGameWindow() {
        GameWindow gameWindow = new GameWindow(this);
        gameWindow.setVisible(true);
        setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
