package javaprojectpractice;

public class Example04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] a=new Object[3];
		Person p =new Person("¿”≤©¡§",22);
		
		a[0]=new Double[]{1.1,2.2,3.3};
		a[1]=new String[]{"a","b","c"};
		a[2]=new Object[]{p,p};
	}
}
class Person{
	String name;
	int age;
	
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
}
