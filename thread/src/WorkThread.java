public class WorkThread extends Thread {

    // 스레드그룹에 스레드를 추가한다.
    public WorkThread(ThreadGroup threadGroup, String threadName){
        super(threadGroup, threadName);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + "interrupted");
                break;
            }
        }
        System.out.println(getName() + "종료됨");
    }
}
