package JabberpointSRC;

import java.util.ArrayList;
/**
 * <p>Presentations keeps track of the slides in a presentation.</p>
 * <p>Only one instance of this class is available.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation {
	private String showTitle; //The title of the presentation
	private final ArrayList<Slide> showList = new ArrayList<>(); //An ArrayList with slides
	private int currentSlideNumber = 0; //The number of the current slide

	public int getSize() {
		return showList.size();
	}

	public String getTitle() {
		return showTitle;
	}

	public void setTitle(String nt) {
		showTitle = nt;
	}

	//Returns the number of the current slide
	public int getSlideNumber() {
		return currentSlideNumber;
	}

	//Change the current slide number
	public void setCurrentSlideNumber(int currentSlideNumber){
		this.currentSlideNumber = currentSlideNumber;
	}

	public ArrayList<Slide> getShowList(){
		return showList;
	}

	public void append(Slide slide) {
		showList.add(slide);
	}

	//Return a slide with a specific number
	public Slide getSlide(int number) {
		if (number < 0 || number >= getSize()){
			return null;
		}
		return showList.get(number);
	}

	//Return the current slide
	public Slide getCurrentSlide() {
		return getSlide(currentSlideNumber);
	}

	public void exit(int n) {
		System.exit(n);
	}
}