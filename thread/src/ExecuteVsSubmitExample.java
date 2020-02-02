import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteVsSubmitExample {
    public static void main(String[] args) throws Exception{
        // 최대 스레드 개수가 2로 고정된 스레드풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 10개의 작업 객체를 만들어주고 작업큐에 넣어준다.
        for(int i=0; i<10; ++i){
            // 작업(Runnable) 정의
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    // 현재 스레드풀의 스레드 수를 얻는다.
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor.getPoolSize();

                    // 현재 스레드풀의 스레드 이름을 얻는다.
                    String threadName = Thread.currentThread().getName();

                    System.out.println("[총 스레드 개수 : " + poolSize + "]" + " [작업 스레드 이름 : " + threadName + "]");

                    // 예외 발생
                    // => execute()로 실행했을때 예외가 발생하면 해당 스레드는 삭제되고 새로운 스레드가 생성된다.
                    // => submit()로 실행했을때 예외가 발생하면 스레드가 종료되지않고 다음 작업을 처리한다.
                    int value = Integer.parseInt("삼"); // numberformatExeception 발생
                }
            };

            // 작업 객체를 작업큐에 넣어서 스레드풀의 스레드가 처리하도록 - execute() 사용
            //executorService.execute(runnable);

            // 작업 객체를 작업큐에 넣어서 스레드풀의 스레드가 처리하도록 - submit() 사용
            executorService.submit(runnable);

            // 예외 발생했을 때 순서대로 올바르게 출력하기 위해 시간을 0.1초 늦춤
            Thread.sleep(100);

        }

        // 스레드풀 종료 - shutdown() => 작업큐에있는 모든 작업들을 처리한다음에 스레드풀을 종료한다.
        executorService.shutdown();

    }
}
