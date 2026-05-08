import javax.swing.*;
import java.awt.*;

public class FloresAnimadas extends JPanel {

    int y = 0;

    public FloresAnimadas() {

        Timer timer = new Timer(40, e -> {

            y += 5;

            if (y > 600) {
                y = -100;
            }

            repaint();
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.CYAN);

        // Tallo
        g.setColor(Color.GREEN);
        g.fillRect(390, y + 40, 10, 80);

        // Pétalos
        g.setColor(Color.YELLOW);

        g.fillOval(370, y + 20, 30, 30);
        g.fillOval(400, y + 20, 30, 30);
        g.fillOval(385, y, 30, 30);
        g.fillOval(385, y + 40, 30, 30);

        // Centro
        g.setColor(Color.ORANGE);
        g.fillOval(385, y + 20, 30, 30);
    }

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Flores Amarillas");

        FloresAnimadas panel = new FloresAnimadas();

        ventana.add(panel);

        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}