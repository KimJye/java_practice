public class YieldExample {
    public static void main(String[] args) {
        YieldThreadA yieldThreadA = new YieldThreadA();
        YieldThreadB yieldThreadB = new YieldThreadB();
        yieldThreadA.start();
        yieldThreadB.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        yieldThreadA.work = false;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        yieldThreadA.work = true;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        yieldThreadA.stop =true;
        yieldThreadB.stop =true;
    }
}
