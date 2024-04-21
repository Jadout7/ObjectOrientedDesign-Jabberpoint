package JabberpointSRC;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

import JabberpointSRC.Constants.*;

/**
 * <p>The applicatiewindow for a slideviewcomponent</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerFrame extends JFrame{
	private final SlideViewerComponent slideViewerComponent;

	public SlideViewerFrame(String title, Presentation presentation) {
		super(title);
		this.slideViewerComponent  = new SlideViewerComponent(presentation, this);
		setupWindow(slideViewerComponent, slideViewerComponent.getPresentation());
	}

	public SlideViewerComponent getSlideViewerComponent() {
		return this.slideViewerComponent;
	}

	//Set up the GUI
	public void setupWindow(SlideViewerComponent slideViewerComponent, Presentation presentation) {
		setTitle(FileInfo.JABTITLE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(slideViewerComponent);
		//Add a controller
		addKeyListener(new KeyController(slideViewerComponent));
		//Sets a Menu
		setMenuBar(new MenuController(this, slideViewerComponent));
		//Sets dimensions for the slide
		setSize(new Dimension(SlideDesign.WIDTH, SlideDesign.HEIGHT));
		setVisible(true);
	}
}