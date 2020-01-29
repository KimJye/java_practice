import java.util.Random;

/**
 * Thread 클래스 상속하여 run 메소드 재정의
 */

class ThreadA extends Thread{
    String name;
    Random random;

    public ThreadA(String name){
        this.name = name;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.println("started " +name);
        try{
            for(int i=0; i<100; ++i){
                System.out.println(name+" " +i);
                int mili = random.nextInt(100);
                sleep(mili);
            }
        }catch (InterruptedException e ){
            System.out.println("interrupted " + name);
        }
        System.out.println("stopped " +name);
    }
}
public class Ex1 {
    public static void main(String[] args) {
        Thread threadOne = new ThreadA("one");
        Thread threadTwo = new ThreadA("two");
        Thread threadThree = new ThreadA("three");
        // 여기까지 메인 스레드만 실행. 스레드 객체들을 생성했을 뿐 아직 스레드 실행 흐름이 생성된 것은 아님.

        // start 메소드 호출로 스레드 실행 흐름이 생성. 각 객체의 run 메소드를 실행된다. 리턴되면 흐름 종료
        // run 메소드가 실행되고 있을 때 main 스레드는 그 다음을 실행
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
