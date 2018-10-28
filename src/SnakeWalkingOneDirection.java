import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeWalkingOneDirection extends KeyAdapter implements SnakeWalking {

    private int xvel, yvel = NO_VELOCITY;

    private Snake snake;

    SnakeWalkingOneDirection(Snake snake) {
        this.snake = snake;
    }
    @Override
    public boolean step() {
       return snake.step(xvel, yvel);
    }

    @Override
    public void reset() {
        xvel = NO_VELOCITY;
        yvel = NO_VELOCITY;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (yvel == NO_VELOCITY) {
                    xvel = NO_VELOCITY;
                    yvel = -VELOCITY;
                }
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (yvel == NO_VELOCITY) {
                    xvel = NO_VELOCITY;
                    yvel = VELOCITY;
                }
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (xvel == NO_VELOCITY) {
                    xvel = VELOCITY;
                    yvel = NO_VELOCITY;
                }
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (xvel == NO_VELOCITY) {
                    xvel = -VELOCITY;
                    yvel = NO_VELOCITY;
                }
                break;
        }
    }
}
