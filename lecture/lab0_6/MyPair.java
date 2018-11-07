package lab0_6;

import java.util.Scanner;

public class MyPair {
	private int x,y;
	
	public MyPair(int x, int y){ //������
		this.x=x;
		this.y=y;
	}

	
	public int sum(){
		return x+y;
	}
	
	public double average(){
		return (  double)(x+y)/2;
	}
	
	public void swap(){
		int temp;
		temp=x;
		x=y;
		y=temp;
	}

	@Override
	public String toString() { //�������̵�
		// TODO Auto-generated method stub
		return "MyPair [x="+x+", y="+y+"]";
	}
}
