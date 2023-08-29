import javax.swing.*;

public class Presenter {

    private ModelTower model;
    private GameWindow gameWindow;

    public Presenter(int numDisks) {
        model = new ModelTower(numDisks);
    }

    public ModelTower getModel() {
        return model;
    }

    public void startGame() {
        gameWindow = new GameWindow(this);
        gameWindow.setVisible(true);
    }

    public void exitGame() {
        gameWindow.closeGameWindow();
    }

    public boolean moveDisk(Tower sourceTower, Tower targetTower) {
        return model.moveDisk(sourceTower, targetTower);
    }

    public boolean checkWin() {
        return model.verifyWin();
    }

    public void solveGame() {
        model.getSolution(model.getNumDisks(),
                          model.getTorreA(),
                          model.getTorreB(),
                          model.getTorreC());
    }

}



