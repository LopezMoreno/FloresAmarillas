import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FloresAnimadas extends JPanel {

    class Flor {
        int x, y;
        int velocidad;

        public Flor(int x, int y, int velocidad) {
            this.x = x;
            this.y = y;
            this.velocidad = velocidad;
        }

        public void mover() {
            y += velocidad;

            // Reinicia arriba cuando sale de la pantalla
            if (y > getHeight()) {
                y = -50;
            }
        }

        public void dibujar(Graphics g) {
            // Pétalos amarillos
            g.setColor(Color.YELLOW);

            g.fillOval(x, y, 20, 20);
            g.fillOval(x + 20, y, 20, 20);
            g.fillOval(x - 20, y, 20, 20);
            g.fillOval(x, y - 20, 20, 20);
            g.fillOval(x, y + 20, 20, 20);

            // Centro naranja
            g.setColor(Color.ORANGE);
            g.fillOval(x, y, 20, 20);

            // Tallo verde
            g.setColor(Color.GREEN);
            g.fillRect(x + 8, y + 20, 4, 40);
        }
    }

    private final ArrayList<Flor> flores = new ArrayList<>();
    private final Timer timer;

    public FloresAnimadas() {

        Random random = new Random();

        // Varias flores
        for (int i = 0; i < 10; i++) {
            flores.add(new Flor(
                    random.nextInt(700),
                    random.nextInt(500),
                    2 + random.nextInt(4)
            ));
        }

        // Animación
        timer = new Timer(40, e -> {
            for (Flor flor : flores) {
                flor.mover();
            }
            repaint();
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fondo celeste
        setBackground(new Color(135, 206, 235));

        for (Flor flor : flores) {
            flor.dibujar(g);
        }
    }

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Flores Amarillas Animadas");

        FloresAnimadas panel = new FloresAnimadas();

        ventana.add(panel);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}