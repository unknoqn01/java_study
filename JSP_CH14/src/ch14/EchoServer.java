package ch14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public EchoServer() {
		try {
			int cnt = 0; //Client의 접속갯수
			ServerSocket server = new ServerSocket(8000);
		System.out.println("ServerSocketStart........");
		while(true) {
			//Client가 접속할때까지 대기 상태
			Socket sock = server.accept(); //wait
			EchoThread et = new EchoThread(sock);
			et.start();
			cnt++;
			System.out.println("Client" + cnt + "socket");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//클라이언트 담당은 Thread로 만들어야 한다.(내부 쿨래스)
	
	class EchoThread extends Thread {
		
		Socket sock;
		BufferedReader in; //Client가 보내는 메세지 받는 스트림
		PrintWriter out; //Client로 메세지 보내는 스트림
		
		public EchoThread(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(
						new InputStreamReader(
								sock.getInputStream()));
				out =new PrintWriter(
						sock.getOutputStream(),true/*auto flush*/);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				//Client가 접속하면 처음으로 받는 메세지
				out.println("Hello Enter BYB to exit");
				while(true) {
					//Client가 메세지 보낼때 까지 대기
					String line = in.readLine();
					if (line==null) { //Client가 접속을 끊을 때
						break; //while문 탈출
					} else {
						//Client에서 온 메세지 앞에 Echo 붙혀서 반사
						out.println("Echo : " + line);
						if (line.equals("BYB")) {
							break;
						}
					}
				}//while
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		new EchoServer();
	}
}
