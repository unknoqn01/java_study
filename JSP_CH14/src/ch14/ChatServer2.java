package ch14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer2 {

	ServerSocket server;
	Vector<ClientThread2> vc;
	int port = 8002;
	
	public ChatServer2() {
		try {
			server = new ServerSocket(port);
			vc = new Vector<ClientThread2>();
			
		} catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("*Server 2.0*******************");
		System.out.println("클라이언트의 접속을 기다리고 있습니다.");
		System.out.println("****************************");
		try {
			while(true) {
				Socket sock = server.accept();//Client 접속 대기 상태
				ClientThread2 ct = new ClientThread2(sock);
				ct.start();//쓰레드 스케줄러에게 등록 -> 스케줄러 시작
				vc.addElement(ct);//벡터에 추가
			}
		} catch (Exception e) {
			System.err.println("Error in Socket");
			e.printStackTrace();
		}
	}
	
	//접속된 모든 클라이언트에게 메세지 전송
	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			ClientThread2 ct = vc.get(i);
			ct.sendMessage(msg);
		}
	}
	
	//Vector에서 ClientThread2 제거
	public void removeClient(ClientThread2 ct) {
		vc.remove(ct);
	}
	
	class ClientThread2 extends Thread{
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "익명";
		
		public ClientThread2(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(
						new InputStreamReader(
								sock.getInputStream()));
				out = new PrintWriter(
						sock.getOutputStream(),true/*auto flush*/);
				System.out.println(sock + " 접속됨...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				//Client에게 최초 보내는 메세지
				out.println("사용하실 아이디를 입력하세요.");
				while(true) {
					String line = in.readLine();
					if(line==null)
						break;
					else
						routine(line);
				}
			} catch (Exception e) {
				//Client 연결이 끊어질때
				//Vector에서 자신의 객체를 제거
				removeClient(this);
				System.err.println(sock + "["+id + "] 끊어짐.");
				//e.printStackTrace();
			}
		}
		
		//Client로 부터 요청된 문자열 분석 메소드
		public void routine(String line) {
			System.out.println("line : " + line);
			//CHATALL:오늘은 월요일입니다.
			int idx = line.indexOf(':');
			String cmd/*CHATALL*/ = line.substring(0, idx);
			String data/*오늘은...*/ = line.substring(idx+1);
			if(cmd.equals(ChatProtocol2.ID)) {
				//data = aaa
				if(data!=null&&data.length()>0) {
					id = data;
					//새로운 접속자 추가 되었기 때문에 리스트 재전송
					sendAllMessage(ChatProtocol2.CHATLIST+":"+getIds());
					//모든 접속자에게 입장 메세지 전송
					sendAllMessage(ChatProtocol2.CHATALL+":"
							+"["+id+"]님이 입이 입장하였습니다.");
				}
			}else if(cmd.equals(ChatProtocol2.CHAT)) {
				//data : bbb;밥묵자
				idx = data.indexOf(';');
				cmd/*bbb*/ = data.substring(0,idx);
				data/*밥묵자*/ = data.substring(idx);
				//bbb 클라이언트 객체
				ClientThread2 ct = findClient(cmd);
				if(ct!=null) {
					ct.sendMessage(ChatProtocol2.CHAT+":"
							+"["+id+"(S)]"+ data);
				} else {//내 자신에게 보냄
					sendMessage(ChatProtocol2.CHAT+":"
							+"["+cmd+"] 접속자가 아닙니다.");
				}
			}else if(cmd.equals(ChatProtocol2.MESSAGE)) {
				idx = data.indexOf(';');
				cmd = data.substring(0,idx);
				data = data.substring(idx);
				ClientThread2 ct = findClient(cmd);
				if(ct!=null) {
					ct.sendMessage(ChatProtocol2.MESSAGE+":"
							+id+";"+ data);
				} else {//내 자신에게 보냄
					sendMessage(ChatProtocol2.CHAT+":"
							+"["+cmd+"] 접속자가 아닙니다.");
				}
			}else if(cmd.equals(ChatProtocol2.CHATALL)) {
				sendAllMessage(ChatProtocol2.CHATALL+":"+"["+id+"]"+data);
			}
		}
		
		//매개변수로 받은 id값으로 ClientThread2를 검색
		public ClientThread2 findClient(String id) {
			ClientThread2 ct = null;
			for (int i = 0; i < vc.size(); i++) {
				ct = vc.get(i);
				if(id.equals(ct.id))
					break;
			}
			return ct;
		}
		
		//접속자 모든 아이디 리턴
		public String getIds() {
			String ids = "";
			for (int i = 0; i < vc.size(); i++) {
				ClientThread2 ct = vc.get(i);
				ids+=ct.id+";";//107라인에서 id값 넣어줌.
			}
			return ids;//aaa;bbb;홍길동;ccc;a123;
		}
		
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}
	
	public static void main(String[] args) {
		new ChatServer2();
	}
}






