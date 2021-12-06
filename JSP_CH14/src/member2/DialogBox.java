package member2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

//검색이 없는 주소 입력시 알림창
public class DialogBox extends JDialog 
implements ActionListener {
	
	JButton b1;
	ZipcodeFrame f;
	
	public DialogBox(ZipcodeFrame f, String title, String msg) {
		super(f, true);
		this.f = f;
		setTitle(title);
		add(new JLabel(msg, JLabel.CENTER));
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		b1 = new JButton("확인");
		p.add(b1);
		b1.addActionListener(this); //이벤트 연결
		
		add(p, BorderLayout.SOUTH);
		
		setSize(250, 150); //알림창 크기
		setLocation(f.getX()+f.getWidth()/2-(this.getWidth()/2),
				f.getY()+f.getHeight()/2-(this.getHeight()/2));
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose(); //창이 사라짐
	}
	

}
