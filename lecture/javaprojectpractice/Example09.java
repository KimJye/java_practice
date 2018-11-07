package javaprojectpractice;

import java.util.Random;

class SharedObj{
   int sum = 0;
   
   synchronized public void add(int i){
      sum += i;
   }
   
   synchronized public void sub(int i){
      sum -= i;
   }
   
}

class ThreadB extends Thread{
   String name;
   int count;
   Random random;
   SharedObj obj;
   
   public ThreadB(String name, int count, SharedObj obj){
      this.name=name;
      this.count=count;
      this.random=new Random();
      this.obj=obj;
   }
   
   @Override
   public void run(){
      System.out.printf("%s is start!", name);
      System.out.println();
      try{
      for(int i=1; i<=count; i++){
         obj.sub(i);
         int ms = random.nextInt(count);
         sleep(ms);
      }
      }
        catch (InterruptedException e) { 
           System.out.println("에뤄");
      }
      System.out.printf("합계: %d, 이름: %s", obj.sum, name);
      System.out.println();
      System.out.printf("%s thread 끝", name);
      System.out.println();
   }
   
}

class ThreadA extends Thread{
   String name;
   int count;
   Random random;
   SharedObj obj;
   
   public ThreadA(String name, int count, SharedObj obj){
      this.name=name;
      this.count=count;
      this.random=new Random();
      this.obj=obj;
   }
   
   @Override
   public void run(){
      System.out.printf("%s is start!", name);
      System.out.println();
      try{
      for(int i=1; i<=count; i++){
         obj.add(i);
         int ms = random.nextInt(count);
         sleep(ms);
      }
      }
        catch (InterruptedException e) { 
           System.out.println("에뤄");
      }
      System.out.printf("합계: %d, 이름: %s", obj.sum, name);
      System.out.println();
      System.out.printf("%s thread 끝", name);
      System.out.println();
   }
}

public class Example09 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      SharedObj obj = new SharedObj();
      
      ThreadA t1 = new ThreadA("t1",100,obj);
      ThreadB t2 = new ThreadB("t2",100,obj);
      t1.start();
      try {
         t1.join();
      } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      t2.start();

   }
   

}