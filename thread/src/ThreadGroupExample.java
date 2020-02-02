import java.util.Map;
import java.util.Set;

public class ThreadGroupExample {
    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setName("AutoSaveThread");
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        // JVM Stack에 있는 모든 스레드들의 정보들을 가져온다.
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();

        // 스레드들만
        Set<Thread> threads = map.keySet();

        // 스레드들 하나씩 가져오기
        for(Thread thread : threads){
            // 스레드 이름과 데몬 스레드인지 확인
            System.out.println("Name: " + thread.getName() + ", " + ((thread.isDaemon())?("데몬"):("주")));

            // 스레드 그룹의 이름 얻기
            System.out.println("\t"+ "소속 그룹: " + thread.getThreadGroup().getName());
            System.out.println();
        }
    }
}
