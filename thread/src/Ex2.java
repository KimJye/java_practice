import java.util.Random;

/**
 * Runnable 인터페이스를 구현하여 run 메소드 재정의
 */

class RunnableA implements Runnable{
    String name;
    Random random;

    public RunnableA(String name){
        this.name = name;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.println("started " + name);
        try{
            for(int i=0; i<100; ++i){
                System.out.println(name + " " +i);
                int mili = random.nextInt(100);
                Thread.sleep(mili);
            }
        }catch (InterruptedException e){
            System.out.println("interrupted "+name);
        }
        System.out.println("stopped "+name);
    }
}
public class Ex2 {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new RunnableA("one"));
        Thread threadTwo = new Thread(new RunnableA("two"));
        Thread threadThree = new Thread(new RunnableA("three"));

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
