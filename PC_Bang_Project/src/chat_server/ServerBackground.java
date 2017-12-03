package chat_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerBackground {

	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGui gui;
	private Map<String,DataOutputStream> clientsMap = new HashMap<String,DataOutputStream>();//사용자들의 정보를 저장하는 맵
	public final void setGui(ServerGui gui){
		this.gui = gui;
	}

	public void setting(){
		try {

			Collections.synchronizedMap(clientsMap);//이걸 교통정리 해줍니다.

			serverSocket = new ServerSocket(7777);//서버가 열림.

			while(true){
				//서버가 할일: 방문자를 계속 받아서,쓰레드 리시버를 계속 생성
				System.out.println("대기중...");
				socket=serverSocket.accept();//서버가 할일은 계속 반복해서 사용자를 받는다.
				System.out.println(socket.getInetAddress()+"에서 접속했습니다.");
				//여기서 새로운 사용자 쓰레드 클래스 생성해서 소켓정보를 넣어줘야한다.
				Receiver receiver= new Receiver(socket);
				receiver.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		ServerBackground serverbackground= new ServerBackground();
		serverbackground.setting();
	}

	//맵의 내용(클라이언트) 저장과 삭제
	public void addClient(String nick, DataOutputStream out) {
		sendMessage(nick+"님이 접속하셨습니다.");
		clientsMap.put(nick, out);
	}
	public void removeClient(String nick){
		sendMessage(nick+"님이 나가셨습니다.");
		clientsMap.remove(nick);
	}
	//메시지 내용 전파
	public void sendMessage(String msg) {
		
		Iterator<String> it = clientsMap.keySet().iterator();
		String key;
		while(it.hasNext()){
			try {
				key=it.next();
				clientsMap.get(it).writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}
	//-----------------------------------------------------------------
	class Receiver extends Thread{
		private DataInputStream in;//메시지를 주고 받으려면 스트림이 필요
		private DataOutputStream out;
		private String nick;

		//XXX 리시버가 할일은 네트워크소켓을 받아서 계속 듣고, 요청하는 일.
		public Receiver(Socket socket){
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());

				//리시버가 처음에는 클라이언트 아이디를 받아옴
				nick = in.readUTF();
				addClient(nick,out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run(){
			String msg;
			try {
				//계속 듣기만!!
				while(in!=null){
					msg=in.readUTF();
					sendMessage(msg);
					gui.appendMsg(msg);
				}
			} catch (IOException e) {
				// 사용 접속 종료시 여기서 에러 발생. 그러면 나간다.
				removeClient(nick);
			}

		}
	}
}
