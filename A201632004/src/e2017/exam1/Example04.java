package e2017.exam1;

public class Example04 {
	static String convertToSnakeCase(String s){
		
		String str=s.toLowerCase();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]a={"helloWorld","oneTwoThree","HowDoYouDo","one"};

		for(String s: a){
			System.out.printf("%s ",convertToSnakeCase(s));
		}
	}

}
