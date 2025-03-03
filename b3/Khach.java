package b3;

public class Khach extends Thread{
    private final Ban ban;

    public Khach(Ban ban){
        this.ban=ban;
    }

    @Override
    public void run() {
        try{
            while(true){
                ban.an();
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
