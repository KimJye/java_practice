public class ProducerThread extends Thread {
    private WorkObject workObject;

    public ProducerThread(WorkObject workObject){
        this.setName("ProducerThread");
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for(int i=1; i<=3; ++i){
            String data = "Data- " + i;
            workObject.setData(data);
        }
    }
}
