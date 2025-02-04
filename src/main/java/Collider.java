import org.jline.terminal.Size;

public class Collider {
    private Size size;
    private boolean enabled;

    public Collider(Size size){
        this.size = size;
        this.enabled = true;
    }

    public Size getSize(){
        return size;
    }
    public boolean isEnabled(){
        return enabled;
    }

    public void switchEnabled(){
        enabled = !enabled;
    }
    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }
}
