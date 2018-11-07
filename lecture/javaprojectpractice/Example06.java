package javaprojectpractice;
import java.util.Comparator;
import java.util.Arrays;

  class Rectangle {
	private int width,height;
	
	public Rectangle(int width,int height){
		this.width=width;
		this.height=height;
	}
	
	public int getWidth(){
		return width;
	}
	public void setWidth(int width){
		this.width=width;
	}
	public int getHeight(){
		return height;
	}
	public void setHeight(int height){
		this.height=height;
	}
	public int getArea(){
		return width*height;
	}
	
}
  class RectangleAreaComparator implements Comparator<Rectangle>{

	@Override
	public int compare(Rectangle a1, Rectangle a2) {
		// TODO Auto-generated method stub
			int r= a1.getArea()-a2.getArea();
		return r;
	}
	@Override
	public String toString(){
		return String.format("Rectangle{%d,%d}",this.getWidth(),this.getHeight());
	}
	  
  }

public class Example06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle a[]=new Rectangle[]{new Rectangle(5,7),new Rectangle(3,2),new Rectangle(7,2),new Rectangle(4,5),new Rectangle(8,2),new Rectangle(6,3)};
		Comparator<Rectangle> comparator=new RectangleAreaComparator();
		Arrays.sort(a,comparator);
		System.out.println(Arrays.toString(a));
	}

}
