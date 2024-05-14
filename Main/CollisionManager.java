package Main;

import java.awt.Graphics2D;

import Entities.Entity;
import Entities.Player;
import TileMaps.Tile;

public class CollisionManager {

	private GamePanel gp;

	public CollisionManager(GamePanel gp) {
		this.gp = gp;
		
	}

	public int checkObject(Entity entity, boolean player) {
	    int index = 1;
	    int entityDefaultx = entity.hitBox.x;
	    int entityDefaulty = entity.hitBox.y;
	    int objectDefaultx = gp.rv.hitBox.x;
	    int objectDefaulty = gp.rv.hitBox.y;
	    
	    System.out.println("Entity Original coordinates: (" +entityDefaultx + ", " + entityDefaulty + ")");
	    System.out.println("Object Original coordinates: (" + entityDefaulty + ", " + entityDefaulty + ")");

	    entity.hitBox.x = entity.worldX + entity.hitBox.x;
	    entity.hitBox.y = entity.worldY + entity.hitBox.y;

	  

	    System.out.println("Entity coordinates: (" + entity.hitBox.x + ", " + entity.hitBox.y + ")");
	    System.out.println("Object coordinates: (" + gp.rv.hitBox.x + ", " + gp.rv.hitBox.y + ")");

	    switch (entity.direction) {
	        case "up":
	            entity.hitBox.y -= entity.speed;
	            if (entity.hitBox.intersects(gp.rv.hitBox)) {
	                if (player) {
	                    index = 0;
	                }
	            }
	            break;
	        case "down":
	            entity.hitBox.y += entity.speed;
	            if (entity.hitBox.intersects(gp.rv.hitBox)) {
	                if (player) {
	                    index = 0;
	                }
	            }
	            break;
	        case "left":
	            entity.hitBox.x -= entity.speed;
	            if (entity.hitBox.intersects(gp.rv.hitBox)) {
	                if (player) {
	                    index = 0;
	                }
	            }
	            break;
	        case "right":
	            entity.hitBox.x += entity.speed;
	            if (entity.hitBox.intersects(gp.rv.hitBox)) {
	                if (player) {
	                    index = 0;
	                }
	            }
	            break;
	    }

	    entity.hitBox.x = entityDefaultx;
	    entity.hitBox.y = entityDefaulty;

	    gp.rv.hitBox.x = objectDefaultx;
	    gp.rv.hitBox.y = objectDefaulty;

	    return index;
	}


	public void checkTile(Entity entity) {
		int entityLeftX = entity.worldX + entity.hitBox.x;
		int entityRightX = entity.worldX+ entity.hitBox.x + entity.hitBox.width;
		int entityTopY = entity.worldY + entity.hitBox.y;
		int entityBottomY = entity.worldY + entity.hitBox.y + entity.hitBox.height;

		int entityLeftCol = entityLeftX/gp.tileSize;
		int entityRightCol = entityRightX/gp.tileSize;
		int entityTopRow = entityTopY/gp.tileSize;
		int entityBottomRow = entityBottomY/gp.tileSize;

		Tile tileOne, tileTwo;

		switch(entity.direction) {
		case "up":
			entityTopRow = (entityTopY - entity.speed)/gp.tileSize;
			System.out.println(entityLeftCol + " " + entityTopY);
			tileOne = gp.tile.getTile(entityLeftCol, entityTopRow);
			tileTwo = gp.tile.getTile(entityRightCol, entityTopRow);

			if((!tileOne.isPassible) || (!tileTwo.isPassible)){
				entity.collision = true;
			}
			System.out.println(tileOne.tileName);
			break;
		case "down":
			entityBottomRow = (entityBottomY + entity.speed)/gp.tileSize;
			tileOne = gp.tile.getTile(entityLeftCol, entityBottomRow);
			tileTwo = gp.tile.getTile(entityRightCol, entityBottomRow);

			if((!tileOne.isPassible) || (!tileTwo.isPassible)){
				entity.collision = true;
			}
			System.out.println(tileOne.tileName);
			break;

		case "left":
			entityLeftCol = (entityLeftX - entity.speed)/gp.tileSize;
			tileOne = gp.tile.getTile(entityLeftCol, entityTopRow);
			tileTwo = gp.tile.getTile(entityLeftCol, entityBottomRow);

			if((!tileOne.isPassible) || (!tileTwo.isPassible)){
				entity.collision = true;
			}
			System.out.println(tileOne.tileName);
			break;
		case "right":
			entityRightCol = (entityRightX + entity.speed)/gp.tileSize;
			tileOne = gp.tile.getTile(entityRightCol, entityTopRow);
			tileTwo = gp.tile.getTile(entityRightCol, entityBottomRow);

			if((!tileOne.isPassible) || (!tileTwo.isPassible)){
				entity.collision = true;
			}
			System.out.println(tileOne.tileName);
			break;
		}
		// 	System.out.println("Left: " + entityLeftCol);
		// 	System.out.println("Right: " + entityRightCol);
		// 	System.out.println("Up: " + entityTopRow);
		// 	System.out.println("Down: " + entityBottomRow);
	}
}
