package view;

import java.io.File;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import java.io.IOException;

public class LoginFrame extends JFrame {
	BufferedImage img=null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton bt; 
	
	//메인
	public static void main(String[] args){
		new LoginFrame();
	}
	//생성자
	public LoginFrame(){
		setTitle("로그인 테스트");
		setSize(1600,900);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//닫기 버튼을 눌렀을 때 Frame창이 사라진다.
		setLayout(null);//절대값 레이아웃(프로그래머가 하나하나 넣어주는)
		
		//이미지 받아오기
		try{
			img= ImageIO.read(new File("img/login.png"));
		}catch(IOException e){
			System.out.println("이미지 불러오기 실패");
			System.exit(0);//프로그램 꺼짐
		}
		//레이아웃 설정
		JLayeredPane layeredPane = new JLayeredPane();//셀로판지처럼 표현해주는 클래스
		layeredPane.setBounds(0, 0, 1600, 900);
		layeredPane.setLayout(null);
		
		//패널만들기(배경)
		MyPanel panel = new MyPanel();
		panel.setBounds(0,0, 1600, 900);//경로 설명, 가로0,세로0,1600,900꽉채워서 보여주자
		
		//로그인 필드
		loginTextField = new JTextField(15);//15글자까지만
		loginTextField.setBounds(731,399,280,30);
		loginTextField.setOpaque(false);//필드투명처리
		loginTextField.setForeground(Color.GREEN);//글자색을 초록색으로, 전경색을 초록색으로
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//경계선 사라지기
		layeredPane.add(loginTextField); 
		//비밀번호 필드
		passwordField = new JPasswordField(15);
		passwordField.setBounds(731,529,280,30);
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.GREEN);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(passwordField);
		
		//버튼 추가
		bt = new JButton(new ImageIcon("img/btLogin_hud.png"));
		bt.setBounds(755,689,104,48);
		//버튼 투명 처리
		bt.setBorderPainted(false);
		bt.setFocusPainted(false);
		bt.setContentAreaFilled(false);
		layeredPane.add(bt);
		
		//마지막 추가들
		layeredPane.add(panel);
		add(layeredPane);//패널을 불러와서 JFrame에 추가해 주겠다.
		setVisible(true);//Frame보여지기
	}
	
	class MyPanel extends JPanel{
		//JPanel에 그림을 그리겠다
		public void paint(Graphics g){
			g.drawImage(img,0,0,null);//저장한 이미지를 불러서 가로0,세로0
		}
	}
	
}
