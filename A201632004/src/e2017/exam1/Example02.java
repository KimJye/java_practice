package e2017.exam1;

public class Example02 {

	static int countVowel(String s){
		String str=s.toLowerCase();
		int n=0;
		for(int i=0;i<s.length();i++){
			if(str.charAt(i)=='a'){
				n++;
			}
			if(str.charAt(i)=='e'){
				n++;
			}
			if(str.charAt(i)=='o'){
				n++;
			}
			if(str.charAt(i)=='i'){
				n++;
			}
			if(str.charAt(i)=='u'){
				n++;
			}
		}
		System.out.print(" ");
		return n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]a={"hello","1234","HELLOworld","aeiou AEIOU"};
		for(String s:a){
			System.out.printf("%d",countVowel(s));
		}
	}

}
