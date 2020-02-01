public class Calculator {
    private int memory;

    public int getMemory(){
        return this.memory;
    }

    public synchronized void setMemory(int memory){
        this.memory = memory;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : " + memory);
    }
}