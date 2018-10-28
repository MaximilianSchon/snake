public class PaintThread extends Thread {
    private SnakeWindow window;


    public PaintThread(SnakeWindow window) {
        this.window = window;
    }
    @Override
    public void run() {
        final int TARGET_FPS = 60;
        final long SLEEP_TIME = 1000 / TARGET_FPS;
        while (true) {
            window.repaint();
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                throw new Error(e);
            }
        }
    }
}
