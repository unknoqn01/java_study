package ch14;

public class ChatProtocol3 {
	
	public static final String ID = "ID";
	//(C->S) ID:aaa;1234
	//(S->C) CHATLIST:aaa;bbb;ccc;ddd;
	
	public static final String CHAT = "CHAT";
	//(C->S) CHAT:받는아이디;채팅메세지 ex)CHAT:bbb;밥묵자
	//(S->C) CHAT:보내는아이디;채팅메세지 ex)CHAT:aaa;밥묵자
	
	public static final String CHATALL = "CHATALL";
	//(C->S) CHATALL:채팅메세지 
	//(S->C) CHATALL:[보내는아이디]채팅메세지 
	
	public static final String MESSAGE = "MESSAGE";
	//(C->S) MESSAGE:받는아이디;쪽지 ex)MESSAGE:bbb;밥묵자
	//(S->C) MESSAGE:보내는아이디;쪽지 ex)MESSAGE:aaa;밥묵자 
	
	
	public static final String CHATLIST = "CHATLIST";
	//(S->C) CHATLIST:aaa;bbb;ccc;ddd;
	
}








