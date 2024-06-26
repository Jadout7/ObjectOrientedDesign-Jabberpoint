package JabberpointSRC;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

import JabberpointSRC.Constants.FileInfo;

/**
 * <p>The class for a Bitmap item</p>
 * <p>Bitmap items are responsible for drawing themselves.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class BitmapItem extends SlideItem{
	private BufferedImage bufferedImage;
	private final String imageName;

	private ImageObserver imageObserver;

	//level indicates the item-level; name indicates the name of the file with the image
	public BitmapItem(int level, String name) {
		super(level);
		imageName = name;
		try {
			bufferedImage = ImageIO.read(new File(imageName));
		} catch (IOException e) {
			System.err.println(FileInfo.FILE + imageName + FileInfo.FILENOTFOUND);
		}
	}

	//Returns the filename of the image
	public String getName() {
		return imageName;
	}

	public void setImageObserver(ImageObserver imageObserver) {
		this.imageObserver = imageObserver;
	}

	//Returns the bounding box of the image
	public Rectangle getBoundingBox(Graphics g, float scale, Style myStyle) {
		return new Rectangle((int) (myStyle.indent * scale), 0, (int) (bufferedImage.getWidth() * scale), ((int) (myStyle.leading * scale)) + (int) (bufferedImage.getHeight() * scale));
	}

	//Draws the image
	public void draw(int x, int y, float scale, Graphics g, Style myStyle) {
		int width = x + (int) (myStyle.indent * scale);
		int height = y + (int) (myStyle.leading * scale);
		g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth() * scale), (int) (bufferedImage.getHeight() * scale), this.imageObserver);
	}

	public String toString() {
		return "BitmapItem[" + getLevel() + "," + imageName + "]";
	}
}