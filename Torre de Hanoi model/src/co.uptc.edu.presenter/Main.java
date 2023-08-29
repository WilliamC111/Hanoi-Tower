import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Presenter presenter = new Presenter(4);
            presenter.startGame();
        });
    }
}
    

