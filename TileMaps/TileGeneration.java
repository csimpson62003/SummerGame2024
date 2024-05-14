package TileMaps;

import java.util.ArrayList;

import myEngine.Image;

public class TileGeneration {
	public ArrayList<Tile> tileList = new ArrayList<Tile>();
	public TileGeneration() {
		//blank tile.
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/blank.png"),"blank",false,-1));
		//Grass tiles
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/grass_sprite_sheet.png").getSubimage(0, 0, 8, 8), "grass", true, 0  ));
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/grass_sprite_sheet.png").getSubimage(8, 0, 8, 8), "grass_water_top", false, 1  ));
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/grass_sprite_sheet.png").getSubimage(24, 0, 8, 8), "grass_water_left", false, 2  ));
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/grass_sprite_sheet.png").getSubimage(16, 0, 8, 8), "grass_water_bottom", false, 3  ));
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/grass_sprite_sheet.png").getSubimage(32, 0, 8, 8), "grass_water_right", false, 4  ));
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/grass_sprite_sheet.png").getSubimage(48, 0, 8, 8), "grass_water_top_right", false, 5  ));
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/grass_sprite_sheet.png").getSubimage(40, 0, 8, 8), "grass_water_top_left", false, 6  ));
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/grass_sprite_sheet.png").getSubimage(56, 0, 8, 8), "grass_water_bottom_left", false, 7  ));
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/grass_sprite_sheet.png").getSubimage(64, 0, 8, 8), "grass_water_bottom_right", false, 8  ));
		
		//Water tiles
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/water.png"), "water", false, 9  ));
		
		//Road Tiles
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/road_sprite_sheet.png").getSubimage(0, 0, 8, 8),"road2",false, 11));
		tileList.add(new Tile(new Image().getImage("/TileMaps/assets/road_sprite_sheet.png").getSubimage(8, 0, 8, 8),"road1",false, 12));

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
