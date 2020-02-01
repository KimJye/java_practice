public class YieldThreadA extends Thread {
    public boolean stop = false;
    public boolean work = true;

    @Override
    public void run() {
        while(!stop){
            if(work){
                System.out.println("YieldThreadA 작업 내용");
            }else{
                Thread.yield();
            }
        }
        System.out.println("YieldThreadA 종료");
    }
}
