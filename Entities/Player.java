package Entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Main.CollisionManager;
import Main.GamePanel;
import myEngine.Image;
import myEngine.KeyListener;

public class Player extends Entity {
	public String name;

	private GamePanel gp;
	// This will change when the player is walking.
	int imageNumber = 0;

	private BufferedImage up0 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(49, 2, 14, 13);
	private BufferedImage up1 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(65, 2, 14, 13);
	private BufferedImage up2 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(81, 2, 14, 13);
	private BufferedImage down0 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(1,2, 14, 13);
	private BufferedImage down1 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(17,2, 14, 13);
	private BufferedImage down2 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(33,2, 14, 13);
	private BufferedImage left0 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(97, 2, 14, 13);
	private BufferedImage left1 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(113, 2, 14, 13);
	private BufferedImage left2 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(129, 2, 14, 13);
	private BufferedImage right0 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(145, 2, 14, 13);
	private BufferedImage right1 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(161, 2, 14, 13);
	private BufferedImage right2 = new Image().getImage("/Entities/assets/player/player_sprite_sheet.png").getSubimage(177, 2, 14, 13);

	public Player(String name, int playerSpeed, GamePanel gp) {
		this.name = name;
		this.gp = gp;
		image = down0;
		speed = playerSpeed;
		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize/ 2);
		
		hitBox = new Rectangle(9, 20, 15, 30); // Adjust hitbox size as needed
		defaultHitBoxX = 9;
		defaultHitBoxY = 9;

		// These below are default values
		direction = "down";
		worldY = gp.worldHeight / 2;
		worldX = gp.worldWidth / 2;
	}

	public void update(KeyListener key) {
		if (key.upPressed || key.downPressed || key.leftPressed || key.rightPressed) {
			if (key.upPressed) {
				if (frameChange > 6) {
					System.out.println("CHANGED");
					if (image == up1) {
						image = up2;
					} else {
						image = up1;
					}
					frameChange = 0;
				} else {
					frameChange++;
				}
				direction = "up";
			}
			if (key.downPressed) {
				if (frameChange > 6) {
					System.out.println("CHANGED");
					if (image == down1) {
						image = down2;
					} else {
						image = down1;
					}
					frameChange = 0;
				} else {
					frameChange++;
				}
				direction = "down";
			}
			if (key.leftPressed) {
				if (frameChange > 6) {
					System.out.println("CHANGED");
					if (image == left1) {
						image = left2;
					} else {
						image = left1;
					}
					frameChange = 0;
				} else {
					frameChange++;
				}
				direction = "left";
			}
			if (key.rightPressed) {
				if (frameChange > 6) {
					System.out.println("CHANGED");
					if (image == right1) {
						image = right2;
					} else {
						image = right1;
					}
					frameChange = 0;
				} else {
					frameChange++;
				}
				direction = "right";
			}

			collision = false;
			gp.collisionManager.checkTile(this);
			int objectIndex = gp.collisionManager.checkObject(this, true);
			if(objectIndex == 0) {
				collision = true;
			}
			System.out.println(objectIndex);

			// Check tile collision. If false, player can move.
			if (!collision) {
				switch (direction) {
				case "up":
					if (hitBox.y > 0) {
						worldY -= speed;
					}
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
				// Update hitbox position based on player position
			}
		} else {
			switch (direction) {
			case "up":
				image = up0;
				break;

			case "down":
				image = down0;
				break;

			case "left":
				image = left0;
				break;

			case "right":
				image = right0;
				break;

			}
		}
	}

	public void render(Graphics2D graphics, GamePanel gp) {
		graphics.drawString(name, screenX + 5, screenY - 15);
		graphics.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		if(gp.showHitbox) {
			graphics.drawRect(9+screenX, 20+screenY, hitBox.width, hitBox.height);
		}
	}
}
