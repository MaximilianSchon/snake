import java.awt.event.KeyListener;

public interface SnakeWalking extends KeyListener {
    int VELOCITY = 1;
    int NO_VELOCITY = 0;

    boolean step();

    void reset();

}
