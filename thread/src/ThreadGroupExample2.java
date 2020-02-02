public class ThreadGroupExample2 {
    public static void main(String[] args) {
        // 현재 main 그룹 아래 main 스레드가 있고 main 그룹의 하위 그룹으로 myGroup이 생성된다.
        ThreadGroup myGroup = new ThreadGroup("myGroup");

        // myGroup 스레드 그룹 아래 두개의 스레드가 포함된다.
        WorkThread workThreadA = new WorkThread(myGroup,"workThreadA");
        WorkThread workThreadB = new WorkThread(myGroup,"workThreadB");

        workThreadA.start();
        workThreadB.start();

        System.out.println("main 스레드 그룹의 list() 메소드 출력 내용 : ");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        mainGroup.list();

        System.out.println();

        // 3초가 메인 스레드를 일시정지하였다가 myGroup을 interrupt하기
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("myGroup 스레드 그룹의 interrupt() 메소드 호출");
        myGroup.interrupt();
    }
}
