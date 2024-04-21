package src;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


import javax.swing.JComponent;
import javax.swing.JFrame;

import src.Constants.SlideDesign;

/**
 * <p>JabberPoint.Presentation.SlideViewerComponent is a graphical component that ca display Slides.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerComponent extends JComponent{

	private Slide slide;
	private final Font labelFont;
	private Presentation presentation;
	private final JFrame frame;

	public SlideViewerComponent(Presentation pres, JFrame frame) {
		setBackground(SlideDesign.BGCOLOR);
		presentation = pres;
		labelFont = new Font(SlideDesign.FONTNAME, SlideDesign.FONTSTYLE, SlideDesign.FONTHEIGHT);
		this.frame = frame;
	}

	public Presentation getPresentation() {
		return this.presentation;
	}

	public void updateSlide(Presentation presentation, Slide data) {
		if (data == null) {
			repaint();
			return;
		}
		this.presentation = presentation;
		this.slide = data;
		repaint();
		frame.setTitle(presentation.getTitle());
	}

	public void setSlideNumber(int number) {
		this.presentation.setCurrentSlideNumber(number);
		this.updateSlide(presentation, this.presentation.getCurrentSlide());
	}

	public void nextSlide() {
		if (presentation.getSlideNumber() < (presentation.getSize() - 1)) {
			setSlideNumber(presentation.getSlideNumber() + 1);
		}
	}

	public void prevSlide() {
		if (presentation.getSlideNumber() > 0) {
			this.setSlideNumber(presentation.getSlideNumber() - 1);
		}
	}

	public void clear() {
		presentation.getShowList().clear();
		setSlideNumber(-1);
	}

	//Draw the slide
	public void paintComponent(Graphics g) {
		g.setColor(SlideDesign.BGCOLOR);
		g.fillRect(0, 0, getSize().width, getSize().height);
		if (presentation.getSlideNumber() < 0 || slide == null) {
			return;
		}
		g.setFont(labelFont);
		g.setColor(SlideDesign.COLOR);
		g.drawString("Slide " + (1 + presentation.getSlideNumber()) + " of " +
					 presentation.getSize(), SlideDesign.XPOS, SlideDesign.YPOS);
		Rectangle area = new Rectangle(0, SlideDesign.YPOS, getWidth(), (getHeight() - SlideDesign.YPOS));
		slide.draw(g, area, this);
	}
}