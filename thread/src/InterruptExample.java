public class InterruptExample {
    public static void main(String[] args) {
        Thread printThread = new PrintThread();
        printThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printThread.interrupt(); // 1초 지난뒤 인터럽트 발생
    }
}
