import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Optional;

public class SnakeDiagonalWalkingWithStopping extends KeyAdapter implements SnakeWalking {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    private HashMap<Integer, Integer> keyMap = new HashMap<>();
    private Snake snake;
    private int[] movingDirections = new int[4];


    public SnakeDiagonalWalkingWithStopping(Snake snake) {
        keyMap.put(KeyEvent.VK_UP, UP);
        keyMap.put(KeyEvent.VK_W, UP);

        keyMap.put(KeyEvent.VK_DOWN, DOWN);
        keyMap.put(KeyEvent.VK_S, DOWN);

        keyMap.put(KeyEvent.VK_LEFT, LEFT);
        keyMap.put(KeyEvent.VK_A, LEFT);

        keyMap.put(KeyEvent.VK_RIGHT, RIGHT);
        keyMap.put(KeyEvent.VK_D, RIGHT);
        this.snake = snake;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Optional<Integer> key = Optional.ofNullable(keyMap.get(e.getKeyCode()));
        key.ifPresent(k -> movingDirections[k] = VELOCITY);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Optional<Integer> key = Optional.ofNullable(keyMap.get(e.getKeyCode()));
        key.ifPresent(k -> movingDirections[k] = NO_VELOCITY);
    }

    public boolean step() {
        return snake.step(movingDirections[RIGHT] - movingDirections[LEFT], movingDirections[DOWN] - movingDirections[UP]);
    }

    @Override
    public void reset() {
        movingDirections = new int[4];
    }
}
