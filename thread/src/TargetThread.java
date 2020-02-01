public class TargetThread extends Thread {
    @Override
    public void run() {
        for(long i=0; i<1000000000; ++i){} // Runnable(CPU 스케쥴러 선택받지않으면) 또는 Run 상태(CPU 스케쥴러 선택받으면)
        try {
            Thread.sleep(1500); // 1.5초 일시정지
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(long i=0; i<1000000000; ++i){} // Runnable(CPU 스케쥴러 선택받지않으면) 또는 Run 상태(CPU 스케쥴러 선택받으면)
    }
}
