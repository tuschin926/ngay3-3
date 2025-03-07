package VisibilityExample;

public class VisibilityExample {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread workerThread = new Thread(() -> {
            while (!flag) {
                System.out.println("Worker thread is running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Worker thread stopped.");
        });

        workerThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;
        System.out.println("Main thread set flag to true.");
    }
}
