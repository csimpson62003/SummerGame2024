package TileMaps;

import java.util.ArrayList;

import myEngine.Image;

public class TileGeneration {
	public ArrayList<Tile> tileList = new ArrayList<Tile>();
	public TileGeneration() {
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/grass.png"), "grass", true, 0  ));
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/water.png"), "water", false, 1  ));
	}
	public Tile getTile(int c) {
		for(Tile tile: tileList) {
			if(tile.key == c) {
				return tile;
			}
		}
		System.out.println("no tiles match the key");
		return null;
	}
}
