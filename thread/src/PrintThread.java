public class PrintThread extends Thread {
    @Override
    public void run() {
        // 일시 정지 상태에서 인터럽트 발생으로 InterruptedException발생 => 별로 좋지 않은 코드
        /*try {
            while (true) {
                System.out.println("실행 중");
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            break;
        }*/
        while (true) {
            System.out.println("실행 중");
//            if(Thread.interrupted()) break;
            if(isInterrupted()) break;
        }

        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}
