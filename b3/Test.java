package b3;

public class Test {
    public static void main(String[] args) {
        Ban ban= new Ban();
        DauBep db= new DauBep(ban);
        Khach khach= new Khach(ban);

        db.start();
        khach.start();
    }
}
