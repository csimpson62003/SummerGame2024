package myEngine;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
public BufferedImage getImage(String filePath) {
	try {
		return ImageIO.read(getClass().getResourceAsStream(filePath));
	} catch (IOException e) {
		System.out.println("Error getting the Image. Error is:\n"+ e);
	}
	return null;
}
}
