import java.util.Random;

/**
 * 계산 결과를 main 스레드가 출력하려면, 계산 스레드가 종료될 때까지 기다렸다가 출력해야 한다.
 */
class ThreadC extends Thread{

    String name;
    int count;
    int sum;
    Random random;

    public ThreadC(String name, int count){
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

public class Ex4 {
    public static void main(String[] args) {
        System.out.println("main thread start");
        ThreadC threadOne = new ThreadC("one", 100);
        ThreadC threadTwo = new ThreadC("two", 100);
        ThreadC threadThree = new ThreadC("three", 100);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        System.out.println("one " + threadOne.sum);
        System.out.println("two " + threadTwo.sum);
        System.out.println("three " + threadThree.sum);

        System.out.println("main thread end");
    }
}
