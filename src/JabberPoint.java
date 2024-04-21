package src;

import javax.swing.JOptionPane;

import src.Constants.Errors;
import src.Constants.FileInfo;

import java.io.IOException;

/**
 * JabberPoint Main Program
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class JabberPoint{
	/**
	 * The main program
	 */
	public static void main(String[] argv) {
		Style.createStyles();
		Presentation presentation = new Presentation();
		SlideViewerFrame slideViewerFrame = new SlideViewerFrame(FileInfo.JABVERSION, presentation);
		try {
			if (argv.length == 0) {
				AccessorLoader.getDemoAccessor().loadFile(presentation, "");
			} else {
				new XMLLoader().loadFile(presentation, argv[0]);
			}
			slideViewerFrame.getSlideViewerComponent().setSlideNumber(0);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, Errors.IOEX + ex, Errors.JABERR, JOptionPane.ERROR_MESSAGE);
		}
	}
}