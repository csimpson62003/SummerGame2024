package Entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public String name;
	public BufferedImage image;
	public String direction;
	public int speed;
	public int screenX,screenY;
	public int worldX,worldY;
	public boolean collision;
	public Rectangle hitBox;
	public int defaultHitBoxX = 0;
	public int defaultHitBoxY = 0;
	//Controlled in the gp, when this hits 12, the players image changed, to stimulate walking.
	//It will then get reset back to zero.
	public int frameChange = 0;
}
