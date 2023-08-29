import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class RoundedBorder extends AbstractBorder {

    private int cornerRadius;

    public RoundedBorder(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arcWidth = cornerRadius * 2;
        int arcHeight = cornerRadius * 2;

        Shape border = new RoundRectangle2D.Double(x + 1, y + 1, width - 3, height - 3, arcWidth, arcHeight); // Ajuste de posición
        g2.setColor(c.getForeground());
        g2.draw(border);

        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(cornerRadius, cornerRadius, cornerRadius, cornerRadius);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = cornerRadius;
        return insets;
    }
}
