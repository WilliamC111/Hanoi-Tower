import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int numDisks = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de discos:"));
            Presenter presenter = new Presenter(numDisks);
            presenter.startGame();
        });
    }
}

