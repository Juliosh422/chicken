import org.jline.terminal.Size;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComposerElementTest {
    @Test
    public void testGetElementSize() {
        ComposerElement composerElement = new ComposerElement("text", ComposerElement.Mode.CENTER);
        Size size = composerElement.getElementSize();
        assertEquals(4, size.getColumns());
        assertEquals(1, size.getRows());
    }

    @Test
    public void testGetOffset() {
        ComposerElement composerElement = new ComposerElement("text", ComposerElement.Mode.CENTER);
        assertEquals(0, composerElement.getOffset());
    }

    @Test
    public void testCreateVerticalArray() {
        ComposerElement composerElement = new ComposerElement("text", ComposerElement.Mode.TOPCENTER);
        String[] verticalArray = composerElement.getAsMatrix();
        assertEquals(4, verticalArray.length);
        assertEquals("t", verticalArray[0]);
        assertEquals("e", verticalArray[1]);
        assertEquals("x", verticalArray[2]);
        assertEquals("t", verticalArray[3]);
    }

    @Test
    public void testGetAsMatrix() {
        ComposerElement composerElement = new ComposerElement("text", ComposerElement.Mode.CENTER);
        String[] asMatrix = composerElement.getAsMatrix();
        assertEquals(1, asMatrix.length);
        assertEquals("text", asMatrix[0]);
    }
}
