import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

import java.awt.geom.Point2D;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static Terminal terminal;

    public static void main(String[] args) throws Exception {
        terminal = TerminalBuilder.terminal();
        terminal.enterRawMode(); // Habilita modo sin bloqueo
        terminal.puts(InfoCmp.Capability.clear_screen);
        terminal.puts(InfoCmp.Capability.enter_ca_mode);
        terminal.puts(InfoCmp.Capability.cursor_invisible);
        Composer composer = new Composer(terminal, new Size(10, 10));

        while (true) {
            if (terminal.reader().ready()) {
                int key = terminal.reader().read();
                if (key == 'q') break; // Salir si se presiona 'q'
            }

            composer.update();
            composer.clear();
            for (int c = 0; c < composer.getColumns(); c++)
                composer.placeString("" + (c%10), new Point2D.Double(c, 0));
            for (int f = 0; f < composer.getRows(); f++)
                composer.placeString("" + (f%10), new Point2D.Double(0, f));
            composer.placeString(new SimpleDateFormat("HH:mm:ss").format(new Date()), new Point2D.Double(1, 1));
            composer.placeString(composer.getSize().toString(), composer.getCenter());
            composer.draw();
            Thread.sleep(1);
        }

        terminal.puts(InfoCmp.Capability.exit_ca_mode);
        terminal.puts(InfoCmp.Capability.cursor_visible);
        terminal.writer().println("Exiting...");
        terminal.flush();
        terminal.close();
    }
}

