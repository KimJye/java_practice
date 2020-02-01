public class WaitNotifyExample {
    public static void main(String[] args) {
        WorkObject sharedObject = new WorkObject();
        ProducerThread waitThreadA = new ProducerThread(sharedObject);
        ConsumerThread waitThreadB = new ConsumerThread(sharedObject);

        waitThreadA.start();
        waitThreadB.start();
    }
}
