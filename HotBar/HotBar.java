package HotBar;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import myEngine.Image;

public class HotBar {
	public HotBar() {

	}

	private Item[] hotBarArray = new Item[5];
	private BufferedImage hotBarAssetImage = new Image().getImage("/HotBar/assets/hot_bar.png");

	public void render(Graphics2D graphics) {
		graphics.drawImage(hotBarAssetImage, 785, 10, hotBarAssetImage.getWidth() * 2, hotBarAssetImage.getHeight() * 2,
				null);
	}
}
