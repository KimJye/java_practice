import java.util.Random;

/**
 * Thread 클래스의 join 메소드
 * 메인 스레드가 스레드 객체의 join 메소드를 호출하면,
 * 그 스레드의 실행흐름이 run 메소드를 리턴하여 종료될 때까지 main 메소드는 대기하다가 리턴한다
 */
class ThreadD extends Thread{

    String name;
    int count;
    int sum;
    Random random;

    public ThreadD(String name, int count){
        this.name = name;
        this.count = count;
        this.sum = 0;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.println("started " + name);
        try{
            for(int i=1; i<=count; ++i){
                sum = sum + i;
                int mili = random.nextInt(10);
                sleep(mili);
            }
        }catch(InterruptedException e){
            System.out.println("interrupted " + name);
        }
        System.out.println("stopped " + name);
    }
}

public class Ex5 {
    public static void main(String[] args) {
        System.out.println("main thread start");
        ThreadD threadOne = new ThreadD("one", 100);
        ThreadD threadTwo = new ThreadD("two", 100);
        ThreadD threadThree = new ThreadD("three", 100);

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        try{
            threadOne.join();
            threadTwo.join();
            threadThree.join();
        }catch(InterruptedException e){
            System.out.println("interrupted");
        }

        System.out.println("one " + threadOne.sum);
        System.out.println("two " + threadTwo.sum);
        System.out.println("three " + threadThree.sum);

        System.out.println("main thread end");
    }
}
