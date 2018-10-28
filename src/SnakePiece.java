import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SnakePiece extends JComponent{
    public static final int WIDTH = SnakeGame.RESOLUTION;
    public static final int HEIGHT = SnakeGame.RESOLUTION;

    private int x, y;

    SnakePiece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x*SnakeGame.RESOLUTION, y*SnakeGame.RESOLUTION, WIDTH, HEIGHT);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SnakePiece) {
            SnakePiece other = (SnakePiece) o;
            return Objects.equals(x, other.x) && Objects.equals(y, other.y);
        }
        return false;
    }
}
