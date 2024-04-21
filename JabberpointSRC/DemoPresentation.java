package JabberpointSRC;

/**
 * A built-in demo presentation
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

class DemoPresentation implements AccessorLoader {

	public void loadFile(Presentation presentation, String unusedFilename) {
		presentation.setTitle("Demo Presentation");
		createJabberPointSlide(presentation);
		createLevelsAndStylesSlide(presentation);
		createThirdSlide(presentation);
	}

	private static void createJabberPointSlide(Presentation presentation) {
		Slide slide = new Slide();
		slide.setTitle("JabberPoint");
		slide.addTextItem(1, "The Java prestentation tool");
		slide.addTextItem(2, "Copyright (c) 1996-2000: Ian Darwin");
		slide.addTextItem(2, "Copyright (c) 2000-now:");
		slide.addTextItem(2, "Gert Florijn and Sylvia Stuurman");
		slide.addTextItem(4, "Calling Jabberpoint without a filename");
		slide.addTextItem(4, "will show this presentation");
		slide.addTextItem(1, "Navigate:");
		slide.addTextItem(3, "Next slide: PgDn or Enter");
		slide.addTextItem(3, "Previous slide: PgUp or up-arrow");
		slide.addTextItem(3, "Quit: q or Q");
		presentation.append(slide);
	}

	private static void createLevelsAndStylesSlide(Presentation presentation) {
		Slide slide = new Slide();
		slide.setTitle("Demonstration of levels and styles");
		slide.addTextItem(1, "Level 1");
		slide.addTextItem(2, "Level 2");
		slide.addTextItem(1, "Again level 1");
		slide.addTextItem(1, "Level 1 has style number 1");
		slide.addTextItem(2, "Level 2 has style number 2");
		slide.addTextItem(3, "This is how level 3 looks like");
		slide.addTextItem(4, "And this is level 4");
		presentation.append(slide);
	}

	private static void createThirdSlide(Presentation presentation) {
		Slide slide = new Slide();
		slide.setTitle("The third slide");
		slide.addTextItem(1, "To open a new presentation,");
		slide.addTextItem(2, "use File->Open from the menu.");
		slide.addTextItem(1, " ");
		slide.addTextItem(1, "This is the end of the presentation.");
		slide.addSlideItem(new BitmapItem(1, "JabberPoint.jpg"));
		presentation.append(slide);
	}
}