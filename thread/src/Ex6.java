import java.util.Random;

/**
 * 공유 변수 문제
 */
class ThreadE extends Thread{
    String name;
    int count;
    static int sum=0;
    Random random;

    public ThreadE(String name, int count){
        this.name = name;
        this.count = count;
        this.random = new Random();
    }

    @Override
    public void run(){
        System.out.println("started "+name);
        try{
            for(int i=1; i<=count; ++i){
                sum = sum + i;
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
public class Ex6 {
    public static void main(String[] args) {
        ThreadE threadOne = new ThreadE("one",100);
        ThreadE threadTwo = new ThreadE("two",100);
        ThreadE threadThree = new ThreadE("three",100);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
