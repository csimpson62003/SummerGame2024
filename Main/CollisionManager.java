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

public void checkTile(Entity entity) {
 	int entityLeftX = entity.xPosition + entity.hitBox.x;
 	int entityRightX = entity.xPosition+ entity.hitBox.x + entity.hitBox.width;
 	int entityTopY = entity.yPosition + entity.hitBox.y;
 	int entityBottomY = entity.yPosition + entity.hitBox.y + entity.hitBox.height;
 	
 	int entityLeftCol = entityLeftX/gp.tileSize;
 	int entityRightCol = entityRightX/gp.tileSize;
 	int entityTopRow = entityTopY/gp.tileSize;
 	int entityBottomRow = entityBottomY/gp.tileSize;
 	
 	Tile tileOne, tileTwo;
 	
 	switch(entity.direction) {
 	case "up":
 		entityTopRow = (entityTopY - entity.speed)/gp.tileSize;
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
