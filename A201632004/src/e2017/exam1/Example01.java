package e2017.exam1;

public class Example01 {

	static String reverse(String s){
		return (new StringBuffer(s)).reverse().append(" ").toString();		
		
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]a={"a","1234","hello"};
		for(String s:a)
			System.out.printf("%s",reverse(s));
	}

}
