package myEngine;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class MouseListener implements java.awt.event.MouseListener{
	
	
	private Cursor cursorIcon = Toolkit.getDefaultToolkit().createCustomCursor(
			new ImageIcon("/myEngine/assets/mouse_icon.png").getImage(),
			new Point(0,0),"custom cursor");

	public Cursor getCursor() {
		return cursorIcon;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
