package b1;

public class SoChan implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<=10; i+=2){
            System.out.println("c: "+i);
        }
    }
}
