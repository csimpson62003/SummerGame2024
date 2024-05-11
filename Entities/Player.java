package Entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import Main.GamePanel;
import myEngine.Image;
import myEngine.KeyListener;

public class Player extends Entity {
    public String name;

    private GamePanel gp;

    public Player(String name, int playerSpeed, GamePanel gp) {
        this.name = name;
        this.gp = gp;
        image = new Image().getImage("/Entities/assets/player/bob_down.png");
        direction = "down";
        speed = playerSpeed;
        xPosition = gp.screenWidth / 2;
        yPosition = gp.screenHeight / 2;
        hitBox = new Rectangle(xPosition, yPosition, 32, 32); // Adjust hitbox size as needed
    }

    public void update(KeyListener key) {
        if (key.upPressed || key.downPressed || key.leftPressed || key.rightPressed) {
            if (key.upPressed) {
                image = new Image().getImage("/Entities/assets/player/bob_up.png");
                direction = "up";
            }
            if (key.downPressed) {
                image = new Image().getImage("/Entities/assets/player/bob_down.png");
                direction = "down";
            }
            if (key.leftPressed) {
                image = new Image().getImage("/Entities/assets/player/bob_left.png");
                direction = "left";
            }
            if (key.rightPressed) {
                image = new Image().getImage("/Entities/assets/player/bob_right.png");
                direction = "right";
            }
            // Check tile collision. If false, player can move.
            if (!collision) {
                switch (direction) {
                    case "up":
                        yPosition -= speed;
                        break;
                    case "down":
                        yPosition += speed;
                        break;
                    case "left":
                        xPosition -= speed;
                        break;
                    case "right":
                        xPosition += speed;
                        break;
                }
                // Update hitbox position based on player position
               // hitBox.setLocation(xPosition, yPosition);
            }
            hitBox.setLocation(xPosition, yPosition);
        }
    }

    public void render(Graphics2D graphics, GamePanel gp) {
        graphics.drawString(name, xPosition + 5, yPosition - 15);
        graphics.drawImage(image, xPosition, yPosition, gp.getTileSize(), gp.getTileSize(), null);
        graphics.draw(hitBox);
    }
}
