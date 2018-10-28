import javax.swing.*;
import java.awt.*;

public class SnakeWindow extends JPanel {
    private Snake snake;

    SnakeWindow(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        snake.update(g);
    }
}
