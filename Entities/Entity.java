package Entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public String name;
	public BufferedImage image;
	public String direction;
	public int speed;
	public int xPosition,yPosition;
	public boolean collision;
	public Rectangle hitBox;
}
