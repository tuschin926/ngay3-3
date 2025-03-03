package b3;

import java.util.LinkedList;

public class Ban {
    private final int ban=5;
    private final LinkedList<String> mon=  new LinkedList<>();

    public synchronized void nau() throws InterruptedException{
        while (mon.size()==ban){
            wait();
        }
        mon.add("THUC AN");
        System.out.println("So mon an : "+mon.size());
        notify();
        Thread.sleep(2000);
    }

    public synchronized void an() throws InterruptedException{
        while(mon.isEmpty()){
            wait();
        }
        mon.removeFirst();
        System.out.println("So mon con lai : "+mon.size());
        notify();
        Thread.sleep(3000);
    }
}
