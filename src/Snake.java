import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Snake extends JComponent {
    public static final int START_X = 200;
    public static final int START_Y = 200;


    private int size = 1;
    private Apple apple = new Apple();
    private LinkedList<SnakePiece> body = new LinkedList<>();

    Snake()  {
        body.add(new SnakePiece(START_X/SnakeGame.RESOLUTION, START_Y/SnakeGame.RESOLUTION));
    }

    @Override
    public synchronized void paint(Graphics g) {
        for (SnakePiece piece : body) {
            piece.update(g);
        }
        apple.update(g);
    }

    synchronized boolean step(int xdir, int ydir) {
        SnakePiece head = body.getFirst();
        int nextX = head.getX() + xdir;
        int nextY = head.getY() + ydir;
        if (nextX < 0 || nextX > Math.floor((SnakeGame.WIDTH - SnakePiece.WIDTH)/SnakeGame.RESOLUTION)||
                nextY < 0 || nextY > Math.floor((SnakeGame.HEIGHT - SnakePiece.HEIGHT)/SnakeGame.RESOLUTION)) return false;
        if (size > 0) head = new SnakePiece(head.getX(), head.getY());
        if (nextX != head.getX() || nextY != head.getY()) {
            SnakePiece nextHead = new SnakePiece(nextX, nextY);
            if (body.contains(nextHead)) return false;
            else body.addFirst(nextHead);
        }
        eat();
        if (size < body.size()) body.removeLast();
        return true;
    }

    void reset() {
        size = 1;
        body = new LinkedList<>();
        body.add(new SnakePiece(START_X/SnakeGame.RESOLUTION, START_Y/SnakeGame.RESOLUTION));
        apple = new Apple();
    }

    private void eat() {
        if (apple.tryToEat(body.getFirst().getX(), body.getFirst().getY())) {
            size++;
            apple = new Apple();
        }
    }
}
