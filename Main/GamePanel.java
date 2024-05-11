package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Entities.Player;
import TileMaps.TileRendering;
import myEngine.KeyListener;


public class GamePanel extends JPanel implements Runnable{
//KeyHandler
KeyListener key = new KeyListener();
//Screen settings stuff.

public final int originalTileSize = 10;
final int scale= 4;

int rectX=0, rectY=0;
private final int FPS = 60;
private final int speed = 3;

private BufferedImage image;

public TileRendering tile = new TileRendering(this);
public Player player = new Player("Bob",3,this);
public CollisionManager collisionManager = new CollisionManager(this);


 final int tileSize = originalTileSize*scale;
 public int getTileSize() {
	 return tileSize;
 }

final int screenCols = 30, screenRows = 20;
public final int screenWidth = tileSize*screenCols;
public final int screenHeight = tileSize*screenRows;

//Thread to run the game loop.


//The actual game panel.
public GamePanel() {
    setPreferredSize(new Dimension(screenWidth, screenHeight));
    setDoubleBuffered(true);
    this.addKeyListener(key);
    this.setFocusable(true);
    this.setBackground(Color.red);
    

}

Thread gameThread;
@Override
public void run() {
	while(gameThread != null) {
		//Setting the games FPS.
		try {
			gameThread.sleep(1000/FPS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		update();
		repaint();
	
	}
}

public void startGameThread() {
	gameThread = new Thread(this);
	gameThread.start();
}

public void update() {
	player.update(key);	
	
}


public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	
	//By casting Graphics2D to g, we have more options and controls.
	Graphics2D graphics = (Graphics2D)g;
	tile.render(graphics, this);
	player.render(graphics, this);
	
	
	//graphics.fillRect(rectX, rectY, 50, 50);
	graphics.dispose();
}

}