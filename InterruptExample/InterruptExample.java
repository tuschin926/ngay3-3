package InterruptExample;

public class InterruptExample {
    public static void main(String[] args) {
        Thread infiniteLoopThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is running...");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        });

        infiniteLoopThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        infiniteLoopThread.interrupt();
    }

}
