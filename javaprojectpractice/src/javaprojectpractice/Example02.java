package javaprojectpractice;

public class Example02 {

	static String getFileName(String path){
		int lastIndex=path.lastIndexOf('/')+1;
		String substring=path.substring(lastIndex);
		return substring;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []a={"c:/data/student/lecture.docx","c:/www/mainpage.html","c:/program files/java/javac.exe"};
		for(String s:a){
			String fileName=getFileName(s);
			System.out.println(fileName);
		}
	}

}
