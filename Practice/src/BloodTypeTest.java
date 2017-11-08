import java.util.Random;

class SharedObj{
	int sum=0;
	synchronized public void add(int num){//락 걸기
		sum+=num;//파라미터 값을 sum변수에 더하기
	}
	synchronized public void sub(int num){
		sum-=num;
	}
}

class ThreadA extends Thread{
	String name;
	int count;
	SharedObj sharedObj;//공유 객체
	Random random;

	public ThreadA(String name, int count,SharedObj sharedObj){
		this.name=name;
		this.count=count;
		this.sharedObj=sharedObj;
		this.random=new Random();
	}

	@Override
	public void run(){
		System.out.printf("%s started\n",name);
		try{
				for(int i=1;i<=count;i++){
					sharedObj.add(i);
					int ms=random.nextInt(count);
					sleep(ms);
				}
		}catch (InterruptedException e){
			System.out.println("error");
		}
		System.out.printf("이름: %s stoped\n",name);
		System.out.printf("이름: %s, 합계: %d\n",name,sharedObj.sum);
	}
}
class ThreadB extends Thread{
	String name;
	int count;
	SharedObj sharedObj;//공유 객체
	Random random;

	public ThreadB(String name, int count,SharedObj sharedObj){
		this.name=name;
		this.count=count;
		this.sharedObj=sharedObj;
		this.random=new Random();
	}

	@Override
	public void run(){
		System.out.printf("%s: started\n",name);
		try{
			for(int i=1;i<=count;i++){
				sharedObj.sub(i);
				int ms=random.nextInt(count);
				sleep(ms);
			}
		}catch (InterruptedException e){
			System.out.printf("%s:interrupted\n",name);
		}
		System.out.printf("이름: %s stoped\n",name);
		System.out.printf("이름: %s, 합계: %d\n",name,sharedObj.sum);
	}
}
public class BloodTypeTest{
	public static void main(String[] args)
	{
		SharedObj sharedObj = new SharedObj();
		ThreadA threadOne = new ThreadA("one",100,sharedObj);
		ThreadB threadTwo = new ThreadB("two",100,sharedObj);
		threadOne.start();
		try {
	         threadOne.join();
	      } catch (InterruptedException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
		threadTwo.start();
	
	}
}