package b2;

public class Main {
    public static void main(String[] args) {
        Runnable a1= new demnguoc() {};
        Thread t1 =new Thread(a1);


        t1.start();
    }
}