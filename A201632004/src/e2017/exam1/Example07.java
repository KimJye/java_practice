package e2017.exam1;

public class Example07 {
	static String getFileExtension(String path){
		char a='.';
		int lastIndex =path.lastIndexOf('.')+1;
		if(path.lastIndexOf(a)==-1){
			String substring=null;
			return "null";
		}
		String substring=path.substring(lastIndex);
		
		return substring+" ";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]a={"c:/data/student/lecture.docx","c:/www/mainpage.html","c:/program files/java/readme"};
		for(String s :a){
			String extension = getFileExtension(s);
			System.out.printf("%s",extension);
		}
	}

}
