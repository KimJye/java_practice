package hw7_1;

import java.util.Stack;
public class Pair {
	private String exp;//�Է¹޴� ���ڿ� (��ȣ��� ����)
	private char testCh, openPair;//testCh�� ���ڿ��� �����ϳ�,openPair�� pop���� �� ������ �����ϳ�

	public boolean testPair(String exp){
		this.exp = exp;
		Stack <Character> s = new Stack <Character>();//Character�� ���� ����;

		for(int i=0; i<exp.length(); i++){
			testCh = exp.charAt(i);//���ڿ����� �ε��� ������� ���ڸ� �ϳ��� �̾Ƴ�

			switch(testCh){//�˻�
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
