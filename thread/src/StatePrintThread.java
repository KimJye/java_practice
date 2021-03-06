/**
 * TargetThread의 상태를 계속해서 출력하는 상태다.
 */
public class StatePrintThread extends Thread {
    private Thread targetThread;

    public StatePrintThread(Thread targetThread){
        this.targetThread = targetThread;
    }

    @Override
    public void run() {
        while(true) {
            // TargetThread의 상태를 얻기
            Thread.State state = targetThread.getState();
            System.out.println("타켓 스레드 상태 : " + state);

            if (state == State.NEW) {
                targetThread.start();
            }
            if (state == State.TERMINATED) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
