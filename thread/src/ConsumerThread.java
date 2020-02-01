public class ConsumerThread extends Thread {
    private WorkObject workObject;

    public ConsumerThread(WorkObject workObject){
        this.setName("ConsumerThread");
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for(int i=1; i<=3; ++i){
            String data = workObject.getData();
        }
    }
}
