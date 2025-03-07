package StarvationExample;

public class StarvationExample{
    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(() -> {
            while (true) {
                System.out.println("High Priority Thread is running");
                Thread.yield();
            }
        });

        Thread lowPriorityThread = new Thread(() -> {
            while (true) {
                System.out.println("Low Priority Thread is running");
                Thread.yield();
            }
        });

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread.start();
    }
}
