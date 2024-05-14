package myEngine;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {
	public boolean upPressed, downPressed, leftPressed, rightPressed;

	public boolean scale = false;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_W) {
			upPressed = true;
		}
		if (keyCode == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if (keyCode == KeyEvent.VK_D) {
			rightPressed = true;
		}
		if (keyCode == KeyEvent.VK_S) {
			downPressed = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (keyCode == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if (keyCode == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if (keyCode == KeyEvent.VK_S) {
			downPressed = false;
		}


	}

}
