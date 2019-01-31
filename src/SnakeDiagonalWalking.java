import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Optional;
import java.util.Queue;

public class SnakeDiagonalWalking extends KeyAdapter implements SnakeWalking {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    private HashMap<Integer, Integer> keyMap = new HashMap<>();
    private Snake snake;
    private int[] movingDirections = new int[4];
    private Queue<Integer> nextRelease = new ArrayDeque<>();


    SnakeDiagonalWalking(Snake snake) {
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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                movingDirections[DOWN] = NO_VELOCITY;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                movingDirections[UP] = NO_VELOCITY;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                movingDirections[LEFT] = NO_VELOCITY;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                movingDirections[RIGHT] = NO_VELOCITY;
                break;
        }
        if (key.isPresent()) {
            nextRelease.remove(key.get());
            if (nextRelease.size() > 0) movingDirections[nextRelease.poll()] = NO_VELOCITY;
            movingDirections[key.get()] = VELOCITY;
        }
        //key.ifPresent(k -> movingDirections[k] = VELOCITY);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int counter = 0;
        for (int i: movingDirections) {
            if (i != 0) counter++;
            }
        Optional<Integer> key = Optional.ofNullable(keyMap.get(e.getKeyCode()));
        if (counter > 1)
            key.ifPresent(k -> movingDirections[k] = NO_VELOCITY);
        else
            key.ifPresent(k -> nextRelease.add(k));
    }

    public boolean step() {
        return snake.step(movingDirections[RIGHT] - movingDirections[LEFT], movingDirections[DOWN] - movingDirections[UP]);
    }

    @Override
    public void reset() {
        movingDirections = new int[4];
    }
}
