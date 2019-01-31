import javax.swing.*;

public class SnakeGame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    public static final int HEIGHT_EXTRA = 35;
    public static final int WIDTH_EXTRA = 6;

    public static final int RESOLUTION = 30;

    private Snake snake;
    private SnakeWalking walking;


    public static void main(String[] args) {
        new SnakeGame().init();
    }

    private void init() {
        JFrame frame = new JFrame("Snake");
        snake = new Snake();
        SnakeWindow window = new SnakeWindow(snake);
        walking = new SnakeDiagonalWalking(snake);
        window.setSize(WIDTH, HEIGHT);
        frame.add(window);
        frame.setResizable(false);
        frame.setSize(WIDTH + WIDTH_EXTRA, HEIGHT + HEIGHT_EXTRA);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(walking);
        Thread draw = new PaintThread(window);
        draw.start();
        snakeLoop();
    }


    private void snakeLoop() {
        final int STEPS_PER_SECOND = 7;
        final long SLEEP_TIME = 1000 / STEPS_PER_SECOND;
        while (walking.step()) {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                throw new Error(e);
            }
        }
        snake.reset();
        walking.reset();
        snakeLoop();
    }

}
