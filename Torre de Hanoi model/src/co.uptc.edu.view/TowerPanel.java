import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

class TowerPanel extends JPanel {

    private Tower tower;

    public TowerPanel(Tower tower) {
        this.tower = tower;
        setPreferredSize(new Dimension(150, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = getWidth() / 2;
        int y = getHeight() - 20;
        for (Disk disk : tower.getDisks()) {
            int width = disk.getSize() * 20;
            g.setColor(Color.BLUE);
            g.fillRect(x - width / 2, y, width, 15);
            y -= 20;
        }
    }
}