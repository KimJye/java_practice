import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        System.out.println("작업 처리 요청");

        class Task implements Runnable{
            private Result result;

            public Task(Result result){
                this.result = result;
            }
            @Override
            public void run() {
                int sum=0;
                for(int i=1; i<=10; ++i){
                    sum+=i;
                }
                result.addValue(sum);
            }
        }

        // 공유 객체(외부 객체)
        Result result = new Result();

        // 두개의 작업을 정의
        Runnable task1 = new Task(result);
        Runnable task2 = new Task(result);

        // 스레드풀의 작업큐에 작업을 넣기
        Future<Result> future1 = executorService.submit(task1, result);
        Future<Result> future2 = executorService.submit(task2, result);

        try {
            result = future1.get();
            result = future2.get();
            System.out.println("처리 결과 : "+ result.accumValue);
            System.out.println("작업 처리 완료");
        } catch (InterruptedException e) {
            System.out.println("인터럽트 예외 발생함 : "+ e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("코드상 예외 발생함 : "+ e.getMessage());
        }

        executorService.shutdown();
    }
}

class Result{
    int accumValue;
    synchronized void addValue(int value){
        accumValue +=value;
    }
}
