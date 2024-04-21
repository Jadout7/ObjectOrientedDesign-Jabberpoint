package JabberpointSRC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import JabberpointSRC.Constants.*;


/** XMLAccessor, reads and writes XML files
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class XMLLoader implements AccessorLoader{

    private String getTitle(Element element, String tagName) {
        NodeList titles = element.getElementsByTagName(tagName);
        return titles.item(0).getTextContent();

    }

    public void loadFile(Presentation presentation, String filename) throws FileNotFoundException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filename);
        }
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File(filename)); //Create a JDOM document
            Element doc = document.getDocumentElement();
            presentation.setTitle(getTitle(doc, PresentationDesign.SHOWTITLE));
            loadSlideFromXML(presentation, doc);
        }
        catch (IOException iox) {
            System.err.println(Errors.IOEX);
        }
        catch (SAXException sax) {
            System.err.println(Errors.SAX);
        }
        catch (ParserConfigurationException pcx) {
            System.err.println(Errors.PCE);
        }
    }

    private void loadSlideFromXML(Presentation presentation, Element doc) {
        int slideNumber, itemNumber, max, maxItems;
        NodeList slides = doc.getElementsByTagName(PresentationDesign.SLIDE);
        max = slides.getLength();
        for (slideNumber = 0; slideNumber < max; slideNumber++) {
            Element xmlSlide = (Element) slides.item(slideNumber);
            Slide slide = new Slide();
            slide.setTitle(getTitle(xmlSlide, PresentationDesign.SLIDETITLE));
            presentation.append(slide);

            NodeList slideItems = xmlSlide.getElementsByTagName(PresentationDesign.ITEM);
            maxItems = slideItems.getLength();
            for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
                Element item = (Element) slideItems.item(itemNumber);
                loadSlideItem(slide, item);
            }
        }
    }

    protected void loadSlideItem(Slide slide, Element item) {
        NamedNodeMap attributes = item.getAttributes();
        int level = getLevel(attributes);
        String type = attributes.getNamedItem(PresentationDesign.KIND).getTextContent();
        if (PresentationDesign.TEXT.equals(type)) {
            slide.addSlideItem(new TextItem(level, item.getTextContent()));
        }
        else {
            if (PresentationDesign.IMAGE.equals(type)) {
                slide.addSlideItem(new BitmapItem(level, item.getTextContent()));
            }
            else {
                System.err.println(Errors.UNKNOWNTYPE);
            }
        }
    }

    private static int getLevel(NamedNodeMap attributes) {
        int level = 1; // default
        String leveltext = attributes.getNamedItem(PresentationDesign.LEVEL).getTextContent();
        if (leveltext != null) {
            try {
                level = Integer.parseInt(leveltext);
            }
            catch(NumberFormatException x) {
                System.err.println(Errors.NFE);
            }
        }
        return level;
    }
}