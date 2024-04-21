package JabberpointSRC;

import java.io.IOException;

/**
 * <p>An Accessor makes it possible to read and write data for a presentation.</p>
 * <p>Non-abstract subclasses should implement the save method.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public interface AccessorSaver {
    void saveFile(Presentation p, String fn) throws IOException;
}