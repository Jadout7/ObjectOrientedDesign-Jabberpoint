package JabberpointSRC;

import java.io.IOException;

/**
 * <p>An Accessor makes it possible to read and write data for a presentation.</p>
 * <p>Non-abstract subclasses should implement the load method.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public interface AccessorLoader {
    static AccessorLoader getDemoAccessor() {
        return new DemoPresentation();
    }

    void loadFile(Presentation p, String fn) throws IOException;
}