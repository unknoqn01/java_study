package ch14;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class ChatClientAWT2 extends MFrame implements ActionListener, Runnable {

	Button bt1, bt2, bt3, bt4;
	TextField tf1, tf2, tf3;
	TextArea area;
	List list;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	String listTitle = "*******대화자명단*******";
	boolean flag = false;

	public ChatClientAWT2() {
		super(500, 600);
		setTitle("ChatClient 2.0");
		Panel p1 = new Panel();
		p1.add(new Label("Host", Label.RIGHT));
		p1.add(tf1 = new TextField("127.0.0.1"));
		p1.add(new Label("Port", Label.RIGHT));
		p1.add(tf2 = new TextField("8002"));
		bt1 = new Button("connect");
		bt1.addActionListener(this);
		p1.add(bt1);
		add(BorderLayout.NORTH, p1);
		// //////////////////////////////////////////////////////////////////////////////////////////
		area = new TextArea("ChatClient 2.0");
		area.setBackground(Color.DARK_GRAY);
		area.setForeground(Color.PINK);
		area.setEditable(false);
		add(BorderLayout.CENTER, area);
		// /////////////////////////////////////////////////////////////////////////////////////////
		Panel p2 = new Panel();
		p2.setLayout(new BorderLayout());
		list = new List();
		list.add(listTitle);
		p2.add(BorderLayout.CENTER, list);
		Panel p3 = new Panel();
		p3.setLayout(new GridLayout(1, 2));
		bt2 = new Button("Save");
		bt2.addActionListener(this);
		bt3 = new Button("Message");
		bt3.addActionListener(this);
		p3.add(bt2);
		p3.add(bt3);
		p2.add(BorderLayout.SOUTH, p3);
		add(BorderLayout.EAST, p2);
		// ///////////////////////////////////////////////////////////////////////////////////////////
		Panel p4 = new Panel();
		tf3 = new TextField("", 50);
		tf3.addActionListener(this);
		bt4 = new Button("send");
		bt4.addActionListener(this);
		p4.add(tf3);
		p4.add(bt4);
		add(BorderLayout.SOUTH, p4);
		validate();
	}

	public void run() {
		try {
			String host = tf1.getText().trim();
			int port = Integer.parseInt(tf2.getText().trim());
			connect(host, port);
			// 서버 -> 사용하실 아이디를 입력하세요
			area.append(in.readLine() + "\n");
			while (true) {
				String line = in.readLine();
				if (line == null)
					break;
				else
					routine(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// --run

	public void connect(String host, int port) {
		try {
			sock = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true/* auto flush */);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// --connect

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == bt1/* connect */) {
			// connect -> 서버 연결하고 run 메소드 호출
			new Thread(this).start();
			bt1.setEnabled(false);
			tf1.setEnabled(false); // host
			tf2.setEnabled(false); // port
			area.setText("");
		} else if (obj == bt2/* save */) {
			String content = area.getText();
			//1970년1월1일 ~현재까지 1/1000초 단위로 계산
			long fileName = System.currentTimeMillis();
			try {
				//경로는 절대경로 || ./(현재폴더)
				FileWriter fw = new FileWriter("./"+fileName+".txt");
				fw.write(content);
				fw.close();
				area.setText("");
				new MDialog(this, "save", "대화내용을 저장하였습니다");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (obj == bt3/* message */) {
			int i = list.getSelectedIndex();
			if (i==-1||i==0) {
				new MDialog(this, "경고", "아이디를 선택하세요");
			}else {
			new Message("TO:");
			}
			} else if (obj == bt4/* send */ || obj == tf3) {
			String str = tf3.getText();
			if (filterMgr(str)) {
				new MDialog(this, "경고", "입력하신 글짜는 금지어입니다.");
				return; // 메소드 중간에 빠져 나가는 결과, 즉 밑에 소스는 의미없어짐
			}
			if (!flag/* 아이디 입력 */) {
				sendMessage(ChatProtocol2.ID + ":" + str); // 서버전송
				setTitle(getTitle() + "-" + str + "님 반갑습니다.");
				area.setText("");
				tf3.setText("");
				tf3.requestFocus();
				flag = true;
			} else/* 일반채팅 */ {
				int i = list.getSelectedIndex();
				if (i == -1 || i == 0) { // 전체채팅
					sendMessage(ChatProtocol2.CHATALL + ":" + str);
				} else { // 귓속말 채팅
					String id = list.getSelectedItem(); // 선택한 id를 리턴
				}
				tf3.setText("");
				tf3.requestFocus();
			}
		}
	}// ----------actionPerformed

	public void routine(String line) {
		int idx = line.indexOf(':');
		String cmd = line.substring(0, idx);
		String data = line.substring(idx + 1);
		if (cmd.equals(ChatProtocol2.CHATLIST)) {
			// data : aaa;bbb;ccc
			list.removeAll(); // 기존에 추가된 item을 모두 삭제
			list.add(listTitle);
			StringTokenizer st = new StringTokenizer(data, ";");
			while (st.hasMoreElements()) {
				list.add(st.nextToken());
			}
		} else if (cmd.equals(ChatProtocol2.CHAT) || cmd.equals(ChatProtocol2.CHATALL)) {
			// CHATALL:[aaa]채팅메세지 & 촘ㅅ:[add(S)] 채팅메세지
			area.append(data + "\n");
		} else if (cmd.equals(ChatProtocol2.MESSAGE)) {
			// data -> bbb;밥묵자
			idx = data.indexOf(';');
			cmd/* bbb */ = data.substring(0, idx);
			data/* 밥묵자 */ = data.substring(idx);
			new Message("FROM", cmd, data);

		}

	}// --routine

	public void sendMessage(String msg) {
		out.println(msg);
	}

	public boolean filterMgr(String msg) {
		boolean flag = false;// false이면 금지어 아님
		String str[] = { "바보", "개새끼", "새끼", "자바", "java" };
		// 하하 호호 히히
		StringTokenizer st = new StringTokenizer(msg);// 생략 가능
		String msgs[] = new String[st.countTokens()];
		for (int i = 0; i < msgs.length; i++) {
			msgs[i] = st.nextToken();
		}
		for (int i = 0; i < str.length; i++) {
			if (flag)
				break; // 첫번째 for문 빠져나감
			for (int j = 0; j < msgs.length; j++) {
				if (str[i].equals(msgs[j])) {
					flag = true;
					break;// 두번째 for문 빠져나감
				} // if
			} // for2
		} // for1
		return flag;
	}

	class Message extends Frame implements ActionListener {

		Button send, close;
		TextField name;
		TextArea ta;
		String mode;// to/from
		String id;

		public Message(String mode) {
			setTitle("쪽지보내기");
			this.mode = mode;
			id = list.getSelectedItem();
			layset("");
			validate();
		}

		public Message(String mode, String id, String msg) {
			setTitle("쪽지읽기");
			this.mode = mode;
			this.id = id;
			layset(msg);
			validate();
		}

		public void layset(String msg) {
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
			Panel p1 = new Panel();
			p1.add(new Label(mode, Label.CENTER));
			name = new TextField(id, 20);
			p1.add(name);
			add(BorderLayout.NORTH, p1);

			ta = new TextArea("");
			add(BorderLayout.CENTER, ta);
			ta.setText(msg);
			Panel p2 = new Panel();
			if (mode.equals("TO:")) {
				p2.add(send = new Button("send"));
				send.addActionListener(this);
			}
			p2.add(close = new Button("close"));
			close.addActionListener(this);
			add(BorderLayout.SOUTH, p2);

			setBounds(200, 200, 250, 250);
			setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == send) {
				sendMessage(ChatProtocol2.MESSAGE + ":" + id + ";" + ta.getText());
			}
			setVisible(false);
			dispose();
		}
	}

	class MDialog extends Dialog implements ActionListener {

		Button ok;
		ChatClientAWT2 ct2;

		public MDialog(ChatClientAWT2 ct2, String title, String msg) {
			super(ct2, title, true);
			this.ct2 = ct2;
			//////////////////////////////////////////////////////////////////////////////////////////
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
			/////////////////////////////////////////////////////////////////////////////////////////
			setLayout(new GridLayout(2, 1));
			Label label = new Label(msg, Label.CENTER);
			add(label);
			add(ok = new Button("확인"));
			ok.addActionListener(this);
			layset();
			setVisible(true);
			validate();
		}

		public void layset() {
			int x = ct2.getX();
			int y = ct2.getY();
			int w = ct2.getWidth();
			int h = ct2.getHeight();
			int w1 = 150;
			int h1 = 100;
			setBounds(x + w / 2 - w1 / 2, y + h / 2 - h1 / 2, 200, 100);
		}

		public void actionPerformed(ActionEvent e) {
			tf3.setText("");
			dispose();
		}
	}

	public static void main(String[] args) {
		new ChatClientAWT2();
	}
}