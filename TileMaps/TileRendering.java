package TileMaps;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Main.GamePanel;
public class TileRendering {
	private int tileSize, column, row;
	private Tile[][] mapArray;
	
	  private static String getRelativePath(File file) {
	        String currentPath = new File(".").getAbsolutePath();
	        String filePath = file.getAbsolutePath();
	        if (filePath.startsWith(currentPath)) {
	            return filePath.substring(currentPath.length() + 1);
	        } else {
	            return filePath; // Return absolute path if not under current directory
	        }
	    }
	
private void readMapFile(){
	TileGeneration tg = new TileGeneration();
	File file = new File("C:\\Users\\Vanil\\Git\\SummerGame2024\\TileMaps\\MapTextFiles\\map01.txt");
	
	Scanner scan;
	try {
		scan = new Scanner(file);
	
	for (int r =0; r < row; r++) {
		for(int c=0; c < column; c++) {
			int index =  scan.nextInt();
			Tile tile = tg.getTile(index);
			mapArray[c][r] = tile;
		}
	}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for (int r =0; r < row; r++) {
		for(int c=0; c < column; c++) {
		}
}
}

public void render(Graphics2D graphics, GamePanel gp) {
	int worldCol = 0;
	int worldRow = 0;
	while(worldCol < gp.worldColumns && worldRow < gp.worldRows) {
		Tile tile = mapArray[worldCol][worldRow];
		int worldX = worldCol * gp.tileSize;
		int worldY = worldRow * gp.tileSize;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		//Render ONLY the tiles that we want the players to see.
		if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX +gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - gp.tileSize< gp.player.worldY +gp.player.screenY){
		graphics.drawImage(tile.tileImage, screenX, screenY, gp.tileSize, gp.tileSize,null);
		}
		worldCol++;
		
		if(worldCol == gp.worldColumns) {
			worldCol = 0;
			worldRow++;
		}
	}
}

public Tile getTile(int column, int row) {
	Tile temp = mapArray[column][row];
	temp.tileColumn = column;
	temp.tileRow = row;
//	
//	System.out.println("TileColumn: "+temp.tileColumn);
//	System.out.println("TileRow: "+temp.tileRow);
	return temp;

}

public TileRendering(GamePanel panel) {
	tileSize = panel.tileSize;
	mapArray = new Tile [panel.worldColumns][panel.worldRows];
	this.column = panel.worldColumns;
	this.row = panel.worldRows;
	readMapFile();
}
}
