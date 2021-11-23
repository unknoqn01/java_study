package ch14;

import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class URLFrameEx1 extends MFrame implements ActionListener {

	TextArea ta;
	TextField tf;
	Button connect;
	Button save;

	public URLFrameEx1() {
		super(500, 500);
		setTitle("ViewHost");
		Panel p = new Panel();
		p.add(tf = new TextField("http://", 40));
		p.add(connect = new Button("connect"));
		p.add(save = new Button("save"));
		ta = new TextArea();
		add("North", p);
		add("Center", ta);
		save.setEnabled(false);
		connect.addActionListener(this);
		save.addActionListener(this);
		tf.addActionListener(this);
	}

	@Override // Annotation : �ּ��� �޴�.
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String host = tf.getText();
		if(obj==tf||obj==connect) {
			ta.setText("");
			save.setEnabled(true);
			connectHost(host);
		}else if(obj==save) {
			createFile(tf.getText(), ta.getText());
			save.setEnabled(false);
			tf.setText("http://");
			ta.setText("");
			ta.append("�����Ͽ����ϴ�.");
			tf.requestFocus();
		}
	}
	
	public void createFile(String file, String content) {
		try {
			FileWriter fw = new FileWriter("ch14/"+file);
			fw.write(content);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�������� ����� �ִ��� ������ ���Ѿ� ��
	public void connectHost(String host) {
		try {
			URL url = new URL(host);
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(
							url.openStream(),"UTF-8"));
			String line = "";
			while(true) {
				line = br.readLine();
				if(line==null) 
					break;
				ta.append(line+"\n");
			}
			br.close();
		} catch (Exception e) {
			ta.append("�ش�Ǵ� ȣ��Ʈ�� �����ϴ�.");
			//e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		URLFrameEx1 ex = new URLFrameEx1();
	}
}








