package test;

import assets.DBConnectionMgr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginTest {
	public static void main(String[] args){
		
		boolean test =loginTest("test","1234");
		
		System.out.println("로그인 결과:"+test);
	}
	
	public static boolean loginTest(String id, String password){
		boolean flag=false;//저장되어있던 로그인 정보가 입력정보와 맞는지 아닌지 확인하는 변수
		
		DBConnectionMgr pool = DBConnectionMgr.getInstance();//DBConnectionMgr객체 가져오기
				
		Connection con =null;
		PreparedStatement pstmt=null;//열차
		ResultSet rs =null;//결과값
		String sql=null;//sql 값
		String getPass=null;//DB에서 가져오는 password 값
		
		//db관련 오류 예외 처리
		try{
			con=pool.getConnection();//connection 받아오기
			//문장 생성
			sql="select password from member_test where id=?";
			
			//문장 연결,열차 준비
			pstmt=con.prepareStatement(sql);
			
			//빈칸 채워주기
			pstmt.setString(1, id);//첫번째 물음표에 id값을 넣어주자.
			
			//실행, 열차 출발
			rs=pstmt.executeQuery();//열차가 한 일들을 받아오기. 결과값으로.executeQuery()=열차 출발메소드
			
			//결과값을 해석하는 과정임.
			if(rs.next()){//만약에 다음줄이 있다면
				//패스워드를 읽어온다.
				getPass= rs.getString("password");//password 칼럼에서 문자를 읽어온다.
				//db에서 읽어온 문자열과 사용자가 입력한 비밀번호가 같을 경우 참을 반환
				if(getPass.equals(password)){
					System.out.println("받아온 비밀번호:" +getPass);
					flag=true;
				}
			}
					
		}catch(Exception e){
			e.printStackTrace();//예외 처리
		}finally{
			//자원 반납. 나머지 닫아준다.
			pool.freeConnection(con,pstmt,rs);
		}
		//최종 결과값
		return flag;
	}
}
