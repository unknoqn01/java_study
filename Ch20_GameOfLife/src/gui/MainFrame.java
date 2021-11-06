package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel = new GamePanel();
	
	public MainFrame() {
		super("Game Of Life"); //티이틀명
		
		setLayout(new BorderLayout()); //레이아웃
		add(gamePanel, BorderLayout.CENTER); //게임패널 가운데
		

		addKeyListener((KeyListener) new KeyListener() { //키이벤트를 대기하면서 발생시 아래코드 실행
			public void keyPressed(KeyEvent e) { // z키보드 키를 눌렸을떄
					//System.out.println("키 눌렀음!");
					int code = e.getKeyCode(); // 키 종류를 숫자로 저장
					switch(code) {
					case 32:
						//System.out.println("스페이스바");
						gamePanel.next();
						break;
					case 8:
						//System.out.println("백 페이스");
						gamePanel.clear();
						break;
					case 10:
						//System.out.println("엔터");
						gamePanel.randomize();
						break;
					}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		
		setSize(1200, 800); //창 사이즈
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을닫을때 프로그램 종료
		setVisible(true); //보이게 하기
	}


}
