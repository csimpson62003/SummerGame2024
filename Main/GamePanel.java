package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Entities.Player;
import HotBar.HotBar;
import TileMaps.TileRendering;
import myEngine.Image;
import myEngine.KeyListener;
import myEngine.MouseListener;
import objects.assets.RecreationalVehicle;

public class GamePanel extends JPanel implements Runnable {
    public final KeyListener key = new KeyListener();
    public final MouseListener mouse = new MouseListener();
    public final int originalTileSize = 10;
    public int scale = 5;
    public  int FPS = 60;
    public  int speed = 3;
    public  int screenCols = 15;
    public  int screenRows = 10;
    public  int worldColumns = 38;
    public  int worldRows = 25;
    
    public final TileRendering tile;
    public final Player player;
    public final CollisionManager collisionManager;
    public final RecreationalVehicle rv;
    
    //HotBar
    
    public final HotBar hotBar = new HotBar();
    
    public  int tileSize = originalTileSize * scale;
    public  int screenWidth = 1280;
    public  int screenHeight = 720;
    public  int worldWidth = tileSize * worldColumns;
    public  int worldHeight = tileSize * worldRows;
    
    //For debugging purposes.
    
    public boolean showHitbox = true;
    
    private Thread gameThread;

    public GamePanel() {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setDoubleBuffered(true);
        this.addKeyListener(key);
        this.addMouseListener(mouse);
        this.setVisible(true);
        this.setFocusable(true);
        this.setBackground(new Color(24,187,230));
        
        tile = new TileRendering(this);
        player = new Player("Bob", 8, this);
        rv = new RecreationalVehicle(this);
        collisionManager = new CollisionManager(this);

    }

    @Override
    public void run() {
        while (gameThread != null) {
            try {
                gameThread.sleep(1000 / FPS);
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D graphics = (Graphics2D) g;
        tile.render(graphics, this);
        rv.render(graphics, this);
        player.render(graphics, this);
        hotBar.render(graphics);
        graphics.dispose();
    }

    
}
