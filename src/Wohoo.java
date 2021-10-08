import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Wohoo extends JFrame {

    Canvas canvas;

    public Wohoo() {
        canvas = new Canvas();
        add(canvas);
        pack();
        setVisible(true);
    }

    public void draw(int x, int y) {
        canvas.draw(x, y);
    }

    static class Canvas extends JPanel {

        BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(image, null, null);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(2000, 2000);
        }

        public void draw(int x, int y) {
            image.setRGB(x, y, Color.WHITE.getRGB());
            repaint();
        }
    }

}
