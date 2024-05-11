package TileMaps;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Main.GamePanel;
public class TileRendering {
	private int column = 30, row = 20;
	private int tileSize;
	private Tile[][] mapArray = new Tile [column][row];
	
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
	File file = new File("C:\\Users\\Vanil\\Documents\\Git\\SummerGame2024\\src\\TileMaps\\MapTextFiles\\map01.txt");
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
	
	int x=0,y=0;
	for (int r =0; r < row; r++) {
		for(int c=0; c < column; c++) {
			Tile tile = mapArray[c][r];
			
			graphics.drawImage(tile.tileImage, x, y, gp.getTileSize(),gp.getTileSize(),null);
			if(!tile.isPassible) {
				//System.out.println("Water Tile X: "+tile.tileX +", Y: "+tile.tileY);
		        graphics.drawRect(x, y, gp.getTileSize(), gp.getTileSize());
			}
			x += tileSize;
		}
		y+=tileSize;
		x=0;
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
	tileSize = panel.getTileSize();
	readMapFile();
}
}
