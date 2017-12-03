package chat_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import chat_server.ServerGui;

public class ClientBackground {
	private Socket socket;
	private DataInputStream in;//메시지를 주고 받으려면 스트림이 필요
	private DataOutputStream out;
	private ClientGui gui;
	private String msg;
	private String nickName;

	public final void setGui(ClientGui gui){
		this.gui = gui;
	}

	public void connet(){
		try {
			socket = new Socket("127.0.0.1",7777);//해당 서버에 연결
			System.out.println("서버 연결되었습니다.");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			//접속하자마자 닉네임 전송하면 서버가 닉네임을 인식하고 Map에 넣는다.
			out.writeUTF(nickName);
			System.out.println("클라이언트: 메시지 전송 완료");

			//클라이언트는 계속 들어야 한다.
			while(in!=null){
				msg=in.readUTF();
				gui.appendMsg(msg);
			}

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientBackground clientbackground = new ClientBackground();
		clientbackground.connet();
	}

	public void sendMessage(String msg2) {
		// TODO Auto-generated method stub
		try {
			out.writeUTF(msg2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setNickname(String nickName) {
		this.nickName= nickName;
	}

}
