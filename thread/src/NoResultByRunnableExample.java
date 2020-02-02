import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultByRunnableExample {
    public static void main(String[] args) {
        // 현재 CPU가 가지고있는 코어 개수만큼 스레드의 최대 개수를 지정
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        System.out.println("작업 처리 요청");

        // 작업 객체 생성
        Runnable task = new Runnable() {
            @Override
            public void run() {
                int sum=0;
                for(int i=1; i<=10; ++i){
                    sum+=i;
                }
                System.out.println("작업 처리 결과 : "+sum);
            }
        };

        // 작업 객체를 스레드풀의 작업큐 저장하는데, 리턴값이 없는 작업이기 때문에 작업객체 하나만 매개변수로~
        // submit은 Future(지연완료객체)를 리턴한다.
        Future future = executorService.submit(task);

        try {
            future.get(); // main메소드가 여기서 블로킹이 되었다가 스레드 풀에서 스레드가 run()을 다 실행하게되면 리턴되어서 아래 코드들을 수행할 수 있다.
            System.out.println("작업 처리 완료");
        } catch (InterruptedException e) {
            System.out.println("인터럽트 예외 발생함 : "+ e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("코드상 예외 발생함 : "+ e.getMessage());
        }

        // 스레드 풀 종료
        executorService.shutdown();
    }
}
