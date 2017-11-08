package hw7_1;

import java.util.Stack;
public class Pair {
	private String exp;//입력받는 문자열 (괄호라고 가졍)
	private char testCh, openPair;//testCh는 문자열중 문자하나,openPair은 pop했을 때 나오는 문자하나

	public boolean testPair(String exp){
		this.exp = exp;
		Stack <Character> s = new Stack <Character>();//Character형 스택 생성;

		for(int i=0; i<exp.length(); i++){
			testCh = exp.charAt(i);//문자열에서 인덱스 순서대로 문자를 하나씩 뽑아냄

			switch(testCh){//검사
			case '(' :
			case '[' :
			case '{' :
			case '<' :
				s.push(testCh);
				break;
			case ')' :
			case ']' :
			case '}' :
			case '>' :	
				if(s.isEmpty()){
					return false;
				}else{
					openPair = s.pop();
					if((openPair=='(') && (testCh!=')') || 
					   (openPair=='[') && (testCh!=']') || 
					   (openPair=='{') && (testCh!='}') ||
					   (openPair=='<') && (testCh!='>')){
						return false;

					}else{
						break;
					}
				}
			}
		}

		if(s.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}
