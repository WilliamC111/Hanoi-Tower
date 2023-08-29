
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TowerPanel extends JPanel {

    private Tower tower;
    private Disk draggedDisk;
    private JLabel backgroundLabel;

    public TowerPanel(Tower tower) {
        this.tower = tower;
        setPreferredSize(new Dimension(150, 400));
        setLayout(new BorderLayout());

        backgroundLabel = new JLabel(new ImageIcon("Fondo.jpg"));
        add(backgroundLabel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (tower.getDisks().isEmpty()) {
                    return;
                }
                draggedDisk = tower.getTopDisk();
                tower.removeDisk();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (draggedDisk != null) {
                    TowerPanel targetPanel = (TowerPanel) e.getComponent();
                    targetPanel.dropDisk(draggedDisk);
                    draggedDisk = null;
                }
            }
        });
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

    public void dropDisk(Disk disk) {
        if (tower.addDisk(disk)) {
            repaint();
        } else {
            tower.addDisk(draggedDisk);
        }
    }
}
