package b2;

public class demnguoc implements Runnable {

    @Override
    public void run() {
        int i;
        for(i=10;i>=0;i--){
            System.out.println("s : "+i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
