import java.util.concurrent.*;

public class ResultByCallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
        
        System.out.println("작업 처리 요청");

        Callable<Integer> task = new Callable() {
            @Override
            public Object call() throws Exception {
                int sum=0;
                for(int i=1; i<=10; ++i){
                    sum+=i;
                }
                return sum;
            }
        };

        Future<Integer> future = executorService.submit(task);

        try {
            int result = future.get();
            System.out.println("처리 결과 : "+ result);
            System.out.println("작업 처리 완료");
        } catch (InterruptedException e) {
            System.out.println("인터럽트 예외 발생함 : "+ e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("코드상 예외 발생함 : "+ e.getMessage());
        }

        executorService.shutdown();
    }
}
