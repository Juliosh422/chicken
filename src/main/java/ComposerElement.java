import org.jline.terminal.Size;

public class ComposerElement {
    public enum Mode{
        CENTER, LEFT, RIGHT, TOPCENTER, TOP, BOTTOM
    }

    private Mode mode;
    private String text;
    private Collider collider;

    public ComposerElement(String text, Mode mode){
        this.text = text;
        this.mode = mode;
        this.collider = null;
    }
    public ComposerElement(String text, Mode mode, boolean collider) {
        this.text = text;
        this.mode = mode;
        if (collider) {
            this.collider = new Collider(getElementSize());
        }
    }

    public Size getElementSize(){
        return new Size(this.getAsMatrix()[0].length(), this.getAsMatrix().length);
    }

    public int getOffset(){
        switch(mode){
            case CENTER:
            case TOPCENTER:
                return 0;
            case LEFT:
            case TOP:
                return 0;
            case RIGHT:
                return -text.length();
            case BOTTOM:
                return 0;
            default:
                return 0;
        }
    }//esto esta mal

    private String[] createVerticalArray(String input){
        String[] result = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            result[i] = String.valueOf(input.charAt(i));
        }
        return result;
    }

    public String[] getAsMatrix(){
        switch (mode){
            case CENTER:
            case LEFT:
            case RIGHT:
                return new String[]{text};
            case TOPCENTER:
            case TOP:
            case BOTTOM:
                return createVerticalArray(text);
            default:
                return new String[]{text};
        }
    }

    public String getText(){
        return text;
    }
    public Mode getMode(){
        return mode;
    }

    public void setText(String text){
        this.text = text;
    }
    public void setMode(Mode mode){
        this.mode = mode;
    }
}
