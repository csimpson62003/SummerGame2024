package TileMaps;

import java.awt.image.BufferedImage;

import myEngine.Image;

public class Tile {
	
	public BufferedImage tileImage; 
	public String tileName;
	public boolean isPassible;
	public int key;
	
	public Tile(BufferedImage tileImage, String tileName, boolean isPassable, int key) {
		this.tileImage = tileImage;
		this.tileName = tileName;
		this.isPassible = isPassable;
		this.key = key;
	}


public BufferedImage getTile() {
 return tileImage;
}
}
