package Main;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameDisplay{
	private BufferedImage image = getIconImage();
	private BufferedImage getIconImage() {
		try {
			 return ImageIO.read(getClass().getResourceAsStream("/Main/boy_down_1.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
		
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setTitle("SummerGame2024");
		window.setSize(new Dimension(1280, 720));
		window.setResizable(false); 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Getting the window icon.

		GamePanel panel = new GamePanel();
		window.add(panel);
		window.pack();
		window.setVisible(true);
		panel.startGameThread();

    }
}