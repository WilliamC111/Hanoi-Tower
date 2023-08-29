import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private Presenter presenter;
    private TowerPanel towerAPanel;
    private TowerPanel towerBPanel;
    private TowerPanel towerCPanel;

    public GameWindow(Presenter presenter) {
        this.presenter = presenter;

        setTitle("Torre de Hanoi");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(1, 3));
        towerAPanel = new TowerPanel(presenter.getModel().getTorreA());
        towerBPanel = new TowerPanel(presenter.getModel().getTorreB());
        towerCPanel = new TowerPanel(presenter.getModel().getTorreC());

        mainPanel.add(towerAPanel);
        mainPanel.add(towerBPanel);
        mainPanel.add(towerCPanel);

        JPanel buttonsPanel = createButtonsPanel();
        add(mainPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();

        JButton moveABButton = new JButton("Move A to B");
        moveABButton.addActionListener(e -> moveDisks(presenter.getModel().getTorreA(), presenter.getModel().getTorreB()));

        JButton moveBCButton = new JButton("Move B to C");
        moveBCButton.addActionListener(e -> moveDisks(presenter.getModel().getTorreB(), presenter.getModel().getTorreC()));

        JButton moveCAButton = new JButton("Move C to A");
        moveCAButton.addActionListener(e -> moveDisks(presenter.getModel().getTorreC(), presenter.getModel().getTorreA()));

        buttonsPanel.add(moveABButton);
        buttonsPanel.add(moveBCButton);
        buttonsPanel.add(moveCAButton);

        return buttonsPanel;
    }

    private void moveDisks(Tower sourceTower, Tower targetTower) {
        if (presenter.moveDisk(sourceTower, targetTower)) {
            updateTowerPanels();
            if (presenter.checkWin()) {
                JOptionPane.showMessageDialog(this, "Congratulations! You won!");
            }
        }
    }

    public void closeGameWindow() {
        setVisible(false);
        dispose();
    }

    public void updateTowerPanels() {
        towerAPanel.repaint();
        towerBPanel.repaint();
        towerCPanel.repaint();
    }
}
