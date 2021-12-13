package ch14;

import java.net.ServerSocket;
import java.net.SocketImpl;

public class TalkServer1 {

	ServerSocket server;
	int port = 8000;
	
	public TalkServer1() { 
		try {
			server = new ServerSocket(port);
			
		} catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1);
		}

	}

	public static void main(String[] args) {
		new TalkServer1();
		
	}
}