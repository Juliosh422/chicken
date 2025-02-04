import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.utils.InfoCmp;

import java.awt.geom.Point2D;

public class Composer {
    private Size size, minimunSize;
    private String[] matrix;
    private final Terminal terminal;

    public Composer(Terminal terminal, Size minimunSize) {
        terminal.puts(InfoCmp.Capability.clear_screen);
        this.terminal = terminal;
        this.minimunSize = minimunSize;
        size = terminal.getSize();
        this.clear();
    }

    public Size update(){
        size = terminal.getSize();
        return size;
    }

    public void clear(){
        matrix = new String[size.getRows()];
        for (int i = 0; i < size.getRows(); i++) {
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < size.getColumns(); j++){
                row.append(' ');
            }
        matrix[i] = row.toString();
        }
    }

    public void placeString(String s, Point2D position) throws IllegalArgumentException {
        int x = (int)position.getX();
        int y = (int)position.getY();
        if (x < 0 || x >= size.getColumns() || y < 0 || y >= size.getRows()) // Si x o y están fuera de los límites
            throw new IllegalArgumentException("Position out of bounds");
        if (x + s.length() > size.getColumns()){
            s = s.substring(0, size.getColumns() - x);
        }
        matrix[y] = matrix[y].substring(0, x) + s + matrix[y].substring(x + s.length());
    }

    public void draw(){
        terminal.puts(InfoCmp.Capability.cursor_home);
    for (int i = 0; i < matrix.length; i++) {
        if (i < matrix.length - 1) {
            terminal.writer().println(matrix[i]);
        } else {
            terminal.writer().print(matrix[i]);
        }
    }
    terminal.flush();
}

    public Point2D getCenter(){
        return new Point2D.Double(Math.floor((double)size.getColumns() / 2), Math.floor((double)size.getRows() / 2));
    }

    public Size getSize() {
        return size;
    }

    public int getRows(){
        return size.getRows();
    }

    public int getColumns(){
        return size.getColumns();
    }

    public void setMinimunSize(Size minimunSize) {
        this.minimunSize = minimunSize;
    }
    public Size getMinimunSize() {
        return minimunSize;
    }
}
