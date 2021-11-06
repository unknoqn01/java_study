package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

import model.World;



public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final static int CELLSIZE = 30; // 격자의 크기 설정
	private final static Color backgroundColor = Color.BLACK; // 배경색 검은색
	private final static Color gridColor = Color.GRAY; // 격자선색 회색

	private int topBottomMargin; // 위 아래 마진
	private int leftRightMargin; // 왼쪽 오른쪽 마진
	private World world; // 월드 선언

	public GamePanel() {
		// 게임패널을 생성시에 이벤트중(마우스 이벤트 추가)
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(e.getY() < topBottomMargin || e.getX() < leftRightMargin) {
					return; // 벗어난 값이기 때문에 그냥 리턴(작은값)
				}
					
				int row = (e.getY() - topBottomMargin) / CELLSIZE;
				int col = (e.getX() - leftRightMargin) / CELLSIZE;
				
				if (row >= world.getRows() || col >= world.getcolumns()) {
					return; //벗어난 값이기 때문에 그냥 리턴(큰값)
				}
				boolean status = world.getCell(row, col);
				world.setCell(row, col, !status);
				repaint(); // 새로고침(게임패널을 새로 시작)
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		// 이 메소드는 자동으로 시작및 수정시 자신의 모습을 그린다.
		Graphics2D g2 = (Graphics2D) g; // 2D 그래픽을 사용하기 위해서

		int width = getWidth(); // 가로길이
		int height = getHeight(); // 세로 길이

		// System.out.println(width);
		// System.out.println(height);

		leftRightMargin = ((width % CELLSIZE) + CELLSIZE) / 2;
		topBottomMargin = ((height % CELLSIZE) + CELLSIZE) / 2;

		int rows = (height - 2 * topBottomMargin) / CELLSIZE;
		int cols = (width - 2 * leftRightMargin) / CELLSIZE;

//		System.out.println(rows);
//		System.out.println(cols);

		if (world == null) { // 아직 world가 생성되지 않았으면 새로 생성
			world = new World(rows, cols);
		} else {// 이미 월드 객체가 만들어져 있다면 
			if(world.getRows() != rows || world.getcolumns() != cols) {
				world = new World(rows, cols);
			}
		}
		//world.setCell(0, 0, true); // grid 이중배열에 좌표(줄,열) 값을 true로 set
		// world.setCell(1, 1, true); //grid 이중배열에 좌표(줄,열) 값을 true로 set
		// world.setCell(3, 5, true); //grid 이중배열에 좌표(줄,열) 값을 true로 set
		// world.setCell(1, 4, true);
		// world.setCell(2, 2, true);

		g2.setColor(backgroundColor); // 색 설정
		g2.fillRect(0, 0, width, height); // 사각형의 좌표에 색을 칠함

		drawGrid(g2, width, height); // 줄을 긋는 메소드

		// 전체 그리드 배열에서 현재 값으로 색을 넣는다.
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				boolean status = world.getCell(row, col);
				fillCell(g2, row, col, status);
			}
		}

	}

	private void fillCell(Graphics2D g2, int row, int col, boolean status) {
		// 사각형에 색을 넣는 메소드( 그래픽객체, 가로줄, 세로줄, 상태(true녹색, false배경색))
		Color color = status ? Color.GREEN : backgroundColor; // 삼항연산자 staus가 true면 녹색
		g2.setColor(color);

		int x = leftRightMargin + (col * CELLSIZE);
		int y = topBottomMargin + (row * CELLSIZE);

		// x,y좌표 가로 세로 길이 입력해서 사각형에 색을 칠한다.
		g2.fillRect(x + 1, y + 1, CELLSIZE - 1, CELLSIZE - 1);
	}

	private void drawGrid(Graphics2D g2, int width, int height) {
		// 격자 줄을 긋는 메소드
		g2.setColor(gridColor); // 색 설정: 검정색

		for (int x = leftRightMargin; x <= width - leftRightMargin; x += CELLSIZE) {
			// 줄을 긋는 메소드 (x1,y1) (x2,y2)
			g2.drawLine(x, topBottomMargin, x, height - topBottomMargin);
		}
		for (int y = topBottomMargin; y <= width - topBottomMargin; y += CELLSIZE) {
			// 줄을 긋는 메소드 (x1,y1) (x2,y2)
			g2.drawLine(leftRightMargin, y, width - leftRightMargin, y);
		}
	}

	public void randomize() {
		//엔터키를 눌렀을때. => 랜덤으로 그리드 생성
		world.randomize();
		//리프레쉬
		repaint();
	}

	public void clear() {
		//백스페이스를 눌렸을때 모든 셀을 false로 만든다
		world.clear();
		//리프레쉬
		repaint();
	}

	public void next() {
		//ㅅ
		world.next();
		
		repaint();
	}
}
