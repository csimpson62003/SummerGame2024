package objects.assets;

import java.awt.Graphics2D;

import Main.GamePanel;
import myEngine.Image;

public class RecreationalVehicle extends ObjectsAndItems{
	public RecreationalVehicle(GamePanel gp) {
		super(900, -50, 4, false, gp);
		setImage("/objects/assets/recreational_vehicle.png");
		setHitBox(0, 100, scale, scale-100);
		// TODO Auto-generated constructor stub
	}

	private GamePanel gp;
	
	
}
