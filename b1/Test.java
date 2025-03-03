package b1;

public class Test {
    public static void main(String[] args) {
        Runnable a1= new SoChan(){};
        Thread t1 =new Thread(a1);

        Runnable b1= new SoLe(){};
        Thread c1 =new Thread(b1);

        t1.start();
        c1.start();
    }
}
