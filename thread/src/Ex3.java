import java.util.Random;

/**
 * Thread 종료 시점
 */

class ThreadB extends Thread{
    String name;
    int count;
    int sum;
    Random random;

    public ThreadB(String name, int count){
        this.name = name;
        this.count = count;
        this.sum=0;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.println("started "+name);
        try{
            for(int i=1; i<=count; ++i){
                sum = sum + i;
                System.out.println("name: " + name + ", sum: " + sum + ", " + i);
                int mili = random.nextInt(10);
                System.out.println("sleep " + name+ " start");
                sleep(mili);
                System.out.println("sleep " +name+ " end");
            }
        }catch (InterruptedException e){
            System.out.println("interrupted "+ name);
        }
        System.out.println(name +" " + sum);
        System.out.println("stopped " + name);
    }
}
public class Ex3 {
    public static void main(String[] args) {
        System.out.println("main thread start");
        Thread threadOne = new ThreadB("one", 100);
        Thread threadTwo = new ThreadB("two", 100);
        Thread threadThree = new ThreadB("three", 100);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        System.out.println("main thread stop");
    }
}
