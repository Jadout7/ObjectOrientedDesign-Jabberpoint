package JabberpointSRC;

import  java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;

import java.io.IOException;

import javax.swing.*;

import JabberpointSRC.Constants.*;

/**
 * <p>The controller for the menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class MenuController extends MenuBar{

    private final SlideViewerComponent slideViewerComponent;
    private final Frame parent;
    private MenuItem menuItem;
    private final Menu fileMenu = new Menu(Buttons.FILE);
    private final Menu viewMenu = new Menu(Buttons.VIEW);
    private final Menu helpMenu = new Menu(Buttons.HELP);

    public MenuController(Frame frame, SlideViewerComponent slideViewerComponent) {
        parent = frame;
        this.slideViewerComponent = slideViewerComponent;
        nextSlide();
        previousSlide();
        moveToSlide();
        about();
        loadPresentation();
        add(fileMenu);
        newPresentation();
        savePresentation();
        exitPresentation();
        setHelpMenu(helpMenu);
    }

    public void nextSlide() {
        viewMenu.add(menuItem = mkMenuItem(Buttons.NEXT));
        menuItem.addActionListener(actionEvent -> slideViewerComponent.nextSlide());
    }

    public void previousSlide() {
        viewMenu.add(menuItem = mkMenuItem(Buttons.PREV));
        menuItem.addActionListener(actionEvent -> slideViewerComponent.prevSlide());
    }

    public void moveToSlide() {
        viewMenu.add(menuItem = mkMenuItem(Buttons.GOTO));
        menuItem.addActionListener(actionEvent -> {
            String pageNumberStr = JOptionPane.showInputDialog(Buttons.PAGENR);
            try {
                int totalSlides = slideViewerComponent.getPresentation().getSize();
                int pageNumber = Integer.parseInt(pageNumberStr);
                if (pageNumber < 1) {
                    // If user inputs a number less than 1, go to the first slide
                    slideViewerComponent.setSlideNumber(0);
                }
                else if (pageNumber > totalSlides) {
                    // If user inputs a number greater than the total number of slides, go to the last slide
                    slideViewerComponent.setSlideNumber(totalSlides - 1);
                }
                else {
                    slideViewerComponent.setSlideNumber(pageNumber - 1);
                }
            }
            catch (NumberFormatException e) {
                // Handle the case when the input cannot be parsed into an integer
                JOptionPane.showMessageDialog(null, "Please enter a valid slide number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void about() {
        add(viewMenu);
        helpMenu.add(menuItem = mkMenuItem(Buttons.ABOUT));
        menuItem.addActionListener(actionEvent -> AboutBox.show(parent));
    }

    public void newPresentation() {
        fileMenu.add(menuItem = mkMenuItem(Buttons.NEW));
        menuItem.addActionListener(actionEvent -> {
            slideViewerComponent.clear();
            parent.repaint();
        });
    }

    public void savePresentation() {
        fileMenu.add(menuItem = mkMenuItem(Buttons.SAVE));
        menuItem.addActionListener(actionEvent -> {
            AccessorSaver xmlSaver = new XMLSaver();
            try {
                xmlSaver.saveFile(slideViewerComponent.getPresentation(), FileInfo.SAVEFILE);
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(parent, Errors.IOEX + exc,
                        Errors.SAVEERR, JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void loadPresentation() {
        fileMenu.add(menuItem = mkMenuItem(Buttons.OPEN));
        menuItem.addActionListener(actionEvent -> {
            AccessorLoader xmlLoader = new XMLLoader();
            try {
                xmlLoader.loadFile(slideViewerComponent.getPresentation(), FileInfo.TESTFILE);
                slideViewerComponent.setSlideNumber(0);
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(parent, Errors.IOEX + exc,
                        Errors.LOADERR, JOptionPane.ERROR_MESSAGE);
            }
            parent.repaint();
        });
    }

    public void exitPresentation() {
        fileMenu.addSeparator();
        fileMenu.add(menuItem = mkMenuItem(Buttons.EXIT));
        menuItem.addActionListener(actionEvent -> slideViewerComponent.getPresentation().exit(0));
    }

    //Creating a menu-item
    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}