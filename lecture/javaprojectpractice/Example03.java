package javaprojectpractice;

public class Example03 {

	public static String toString(String[]a){
		StringBuilder str =new StringBuilder();
		str.append("{");
		
		for(String list: a){
			if(str.length()>1){
				str.append(", ");
			}
			str.append('"'+list+'"');
		}
		str.append("]");
		return str.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]a={"one","two","three","four"};
		String s=toString(a);
		System.out.println(s);
	}

}
