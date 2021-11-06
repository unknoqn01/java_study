package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.World;







public class GamePanel<Graphics2D> extends JPanel {
	private static final long serialVersionUID = 1L;
	private final static int CELLSIZE = 100;
	private final static Color backgroungColor = Color.black;
	private final static Color gridColor = Color.gray;
	
	private int topBottomMargin;
	private int leftRightMargin;
	private World world;
	
	public GamePanel() {

	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g; 
		
		int width = getWidth();
		int height = getHeight();
		
		
		
		
	}
	
}
