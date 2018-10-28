import javax.swing.*;
import java.awt.*;

public class Apple extends JComponent {
    public static final int WIDTH = SnakeGame.RESOLUTION;
    public static final int HEIGHT = SnakeGame.RESOLUTION;

    private int x;
    private int y;

    Apple() {
        this.x = (int) (Math.random() * Math.floor((SnakeGame.WIDTH-WIDTH)/SnakeGame.RESOLUTION));
        this.y = (int) (Math.random() * Math.floor((SnakeGame.HEIGHT-HEIGHT)/SnakeGame.RESOLUTION));
    }

    boolean tryToEat(int snakeX, int snakeY) {
        return snakeX == x && snakeY == y;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x*SnakeGame.RESOLUTION,y*SnakeGame.RESOLUTION, WIDTH, HEIGHT);
    }

}
