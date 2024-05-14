package objects.assets;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Main.GamePanel;
import myEngine.Image;

public class ObjectsAndItems {
	public int worldX;
	public int worldY;
	public int scale = 4;
	public boolean isPassible = true;
	public BufferedImage image = null;
	public boolean showHitBox = false;
	public Rectangle hitBox;
	public int defaultHitBoxX = 0;
	public int defaultHitBoxY = 0;
	public ObjectsAndItems(int worldX, int worldY, int scale, boolean isPassible,GamePanel gp) {
		this.worldX = worldX;
		this.worldY = worldY;
		this.scale = scale * gp.tileSize;
		this.isPassible = isPassible;
	}
	
	public void setImage(String imgString) {
		this.image = new Image().getImage(imgString);
	}
	public void setHitBox(int x, int y, int width, int height) {
		hitBox = new Rectangle(worldX + x, worldY + y,width,height);
		defaultHitBoxX = x;
		defaultHitBoxY = y;
	}
	
	
	
	public void render(Graphics2D graphics, GamePanel gp) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		graphics.drawImage(image, screenX, screenY, scale, scale,null);
		if(gp.showHitbox) {
		graphics.draw(new Rectangle(screenX +hitBox.x-worldX, screenY+hitBox.y-worldY, hitBox.width,hitBox.height));
		}
		
	}
}
