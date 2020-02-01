import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.NotThreadSafe;

import java.util.Random;

/**
 * 공유 변수 문제를 락으로 해결
 */
@NotThreadSafe
class ThreadF extends Thread{
    String name;
    int count;
    @GuardedBy("th") static int sum=0;
    Random random;

    public ThreadF(String name, int count){
        this.name = name;
        this.count = count;
        this.random = new Random();
    }

    @Override
    public void run(){
        System.out.println("started "+name);
        try{
            for(int i=1; i<=count; ++i){
                synchronized ("a"){
                    sum = sum + i;
                }
                int mili = random.nextInt(10);
                sleep(mili);
            }
        }catch (InterruptedException e){
            System.out.println("interrupted "+ name);
        }
        System.out.println("stopped "+name);
        System.out.println("result : "+name+" " +sum);
    }
}
public class Ex7 {
    public static void main(String[] args) {
        ThreadF threadOne = new ThreadF("one",100);
        ThreadF threadTwo = new ThreadF("two",100);
        ThreadF threadThree = new ThreadF("three",100);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
