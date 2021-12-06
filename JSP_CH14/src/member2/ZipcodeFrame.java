package member2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ZipcodeFrame extends Frame implements ActionListener{

	JLabel label;
	JButton searchBtn, selectBtn;
	List list;
	TextField tf;
	JPanel p1,p2;
	ZipcodeMgr mgr;
	DialogBox err1, err2;

	
	public ZipcodeFrame() {
		setTitle("ZipcodeFrame");
		setBounds(500,500,300,500);
		mgr = new ZipcodeMgr();
		p1=new JPanel();
		p1.setBackground(Color.LIGHT_GRAY);
		p1.add(label = new JLabel ("동이름:",label.CENTER));
		p1.add(tf = new TextField("강남대로",15));
		p1.add(searchBtn = new JButton("검색"));
		tf.addActionListener(this);
		searchBtn.addActionListener(this); 
		//////////////////////////////////////
		list = new List();
		list.addActionListener(this);
		//////////////////////////////////////
		p2=new JPanel();
		p2.add(selectBtn = new JButton("선택"));
		selectBtn.addActionListener(this);
		p2.setBackground(Color.LIGHT_GRAY);
		///////////////////////////////////////
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		add(p1,BorderLayout.NORTH);
		add(list,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
		tf.requestFocus();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//모든 클래스 객체를 Object가 레퍼런스 할 수 있다.
		//Object obj1 =  new String();//객체불변의 법치
		Object obj = e.getSource();
		if(obj==searchBtn||obj==tf) {
			if(tf.getText().trim().length()==0) {
				if(err1==null) {
					err1 = new DialogBox(this, "알림","검색어를 입력하세요.");
				}else {
					err1.setLocation(this.getX()+this.getWidth()/2-(err1.getWidth()/2),
							this.getY()+this.getHeight()/2-(err1.getHeight()/2));
					err1.setVisible(true);
				}
			} else {//검색 결과를 list 추가
				list.removeAll();//기존 검색결과를 제거
				Vector<ZipcodeBean> vlist = 
						mgr.zipcodeRead(tf.getText()/*강남대로*/);
				if(vlist.isEmpty()) {//결과값이 없을때
					if(err2==null) {
						err2 = new DialogBox(this, "알림","검색 결과가 없습니다.");
					}else {
						err2.setLocation(this.getX()+this.getWidth()/2-(err2.getWidth()/2),
								this.getY()+this.getHeight()/2-(err2.getHeight()/2));
						err2.setVisible(true);
					}
					tf.setText("");
				}else {
					for (int i = 0; i < vlist.size(); i++) {
						ZipcodeBean bean = vlist.get(i);
						String str = bean.getZipcode()+" ";
						str+= bean.getArea1() +" ";
						str+= bean.getArea2() +" ";
						str+= bean.getArea3() +" ";
						list.add(str);
					}
				}
			}
		}else if(obj==list||obj==searchBtn) {
			
		}
	}
	
	
	public static void main(String[] args) {
		new ZipcodeFrame();
	}
}





