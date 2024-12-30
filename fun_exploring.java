import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BouncingBalls extends JPanel implements ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_COUNT = 10;

    private final int[] x = new int[BALL_COUNT];
    private final int[] y = new int[BALL_COUNT];
    private final int[] dx = new int[BALL_COUNT];
    private final int[] dy = new int[BALL_COUNT];
    private final int[] ballSize = new int[BALL_COUNT];
    private final Color[] colors = new Color[BALL_COUNT];

    private final Timer timer = new Timer(10, this);

    public BouncingBalls() {
        Random random = new Random();

        for (int i = 0; i < BALL_COUNT; i++) {
            x[i] = random.nextInt(WIDTH - 50);
            y[i] = random.nextInt(HEIGHT - 50);
            dx[i] = random.nextInt(5) + 1;
            dy[i] = random.nextInt(5) + 1;
            ballSize[i] = random.nextInt(20) + 20;
            colors[i] = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        for (int i = 0; i < BALL_COUNT; i++) {
            g.setColor(colors[i]);
            g.fillOval(x[i], y[i], ballSize[i], ballSize[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < BALL_COUNT; i++) {
            x[i] += dx[i];
            y[i] += dy[i];

            if (x[i] < 0 || x[i] + ballSize[i] > WIDTH) {
                dx[i] = -dx[i];
            }
            if (y[i] < 0 || y[i] + ballSize[i] > HEIGHT) {
                dy[i] = -dy[i];
            }
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Balls Simulation");
        BouncingBalls panel = new BouncingBalls();
        frame.add(panel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
