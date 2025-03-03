package b3;

public class DauBep extends Thread{
    private final Ban ban;

    public DauBep(Ban ban){
        this.ban=ban;
    }

    @Override
    public void run() {
        try{
            while(true){
                ban.nau();
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
