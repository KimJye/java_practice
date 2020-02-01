public class WorkObject {
    private String data;

    public synchronized String getData() {

        // 데이터가 없으면 소비자 스레드는 대기 상태로!
        if(this.data==null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 읽을 데이터가 있으면 데이터를 읽고, 데이터를 null 상태로 만든다.
        String returnValue = data;
        System.out.println("ConsumerThread가 읽은 데이터 : " + returnValue);
        data = null;

        // 소비자 스레드의 작업이 끝났으니 생성자 스레드를 실행 대기로 만들어 놓는다.
        notify();
        return returnValue;
    }

    public synchronized void setData(String data) {
        // 소비자 스레드가 데이터를 읽으면 데이터를 null로 명시했다.
        // 따라서 데이터가 null이 아니면 아직 소비자 스레드가 데이터를 읽은 것이 아니다.
        // 그래서 생성자 스레드가 데이터를 저장하면 안되도록 해야하니 생성자 스레드를 waiting 상태로 만든다.
        if(this.data != null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 새로운 데이터 저장
        this.data = data;
        System.out.println("ProducerThread가 생성한 데이터 : " + data);

        // 새로운 데이터를 저장해 두었으니 이제 읽어야 하니,
        // 생성자 스레드는 waiting 상태로 만들고 소비자 스레드는 실행 대기 상태로 만든다.
        notify();
    }
}
