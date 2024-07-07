package kasirpro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class game extends JPanel implements ActionListener, KeyListener {

    private final int TILE_SIZE = 25;
    private final int GRID_SIZE = 20;
    private final int BOARD_SIZE = TILE_SIZE * GRID_SIZE;
    private final int ALL_TILES = GRID_SIZE * GRID_SIZE;

    private final int[] x = new int[ALL_TILES];
    private final int[] y = new int[ALL_TILES];

    private int snakeLength;
    private int appleX;
    private int appleY;
    private int score; // Menambahkan variabel skor

    private boolean running = true;
    private char direction = 'R'; // U, D, L, R
    private Timer timer;

    public game() {
        setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
        setBackground(Color.CYAN);
        setFocusable(true);
        addKeyListener(this);

        startGame();
    }

    private void startGame() {
        snakeLength = 3;
        score = 0; // Inisialisasi skor
        for (int i = 0; i < snakeLength; i++) {
            x[i] = 50 - i * TILE_SIZE;
            y[i] = 50;
        }
        spawnApple();

        timer = new Timer(150, this);
        timer.start();
    }

    private void spawnApple() {
        Random random = new Random();
        appleX = random.nextInt(GRID_SIZE) * TILE_SIZE;
        appleY = random.nextInt(GRID_SIZE) * TILE_SIZE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (running) {
            g.setColor(Color.RED);
            g.fillRect(appleX, appleY, TILE_SIZE, TILE_SIZE);

            for (int i = 0; i < snakeLength; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(new Color(45, 180, 0));
                }
                g.fillRect(x[i], y[i], TILE_SIZE, TILE_SIZE);
            }

            // Menambahkan skor ke tampilan
            g.setColor(Color.BLACK);
            g.setFont(new Font("Helvetica", Font.BOLD, 18));
            g.drawString("Score: " + score, 10, 20);
        } else {
            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {
        String message = "Mas Aziz Ganteng";
        Font font = new Font("Helvetica", Font.BOLD, 40);
        FontMetrics metrics = getFontMetrics(font);

        g.setColor(Color.GRAY);
        g.setFont(font);
        g.drawString(message, (BOARD_SIZE - metrics.stringWidth(message)) / 2, BOARD_SIZE / 2);
        g.drawString("Score: " + score, (BOARD_SIZE - metrics.stringWidth("Score: " + score)) / 2, BOARD_SIZE / 2 + 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollision();
        }
        repaint();
    }

    private void move() {
        for (int i = snakeLength; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] -= TILE_SIZE;
                break;
            case 'D':
                y[0] += TILE_SIZE;
                break;
            case 'L':
                x[0] -= TILE_SIZE;
                break;
            case 'R':
                x[0] += TILE_SIZE;
                break;
        }
    }

    private void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            snakeLength++;
            score += 10; // Menambahkan skor setiap kali ular makan apel
            spawnApple();
        }
    }

    private void checkCollision() {
        for (int i = snakeLength; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
                break;
            }
        }

        if (x[0] < 0 || x[0] >= BOARD_SIZE || y[0] < 0 || y[0] >= BOARD_SIZE) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (direction != 'R')) {
            direction = 'L';
        }

        if ((key == KeyEvent.VK_RIGHT) && (direction != 'L')) {
            direction = 'R';
        }

        if ((key == KeyEvent.VK_UP) && (direction != 'D')) {
            direction = 'U';
        }

        if ((key == KeyEvent.VK_DOWN) && (direction != 'U')) {
            direction = 'D';
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("MOBILE LEGEND tahun 90-an");
        game gamePanel = new game();
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
