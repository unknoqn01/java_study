package ch14;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

class TalkAWT1 extends MFrame implements ActionListener{
	
	TextField idTx, pwTx;
	Label logo, idl, pwl, msgl;
	Button loginBtn;
	Socket sock;
	
	public TalkAWT1() {
								
		super(450, 400, new Color(200, 50, 192));
		setTitle("Talk 1.0");
		setLayout(null);
		logo = new Label("Talk 1.0");
		logo.setFont(new Font("Dialog", Font.BOLD, 50));
		
		idl = new Label("ID");
		pwl = new Label("PW");
		idTx = new TextField("aaaa");
		pwTx = new TextField("1234");
		loginBtn = new Button("로그인");
		msgl = new Label("ID와 PW를 입력하세요");
		
		logo.setBounds(100, 50, 250, 100);
		idl.setBounds(150, 200, 50, 20);
		idTx.setBounds(200, 200, 50, 20);
		pwl.setBounds(150, 230, 50, 20);
		pwTx.setBounds(200, 230, 50, 20);
		loginBtn.setBounds(150, 275, 100, 20);
		msgl.setBounds(150, 320, 150, 40);
		loginBtn.addActionListener(this);
		
		add(logo);
		add(idl);
		add(idTx);
		add(pwl);
		add(pwTx);
		add(loginBtn);
		add(msgl);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		try {
			if (obj==loginBtn) {
				if (sock == null) {
					sock = new Socket("127.0.0.1", 8000);
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TalkAWT1();
	}
	
}