package org.example;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        Terminal terminal = TerminalBuilder.terminal();
        terminal.enterRawMode(); // Habilita modo sin bloqueo
        terminal.puts(InfoCmp.Capability.clear_screen);
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        while (true) {
            if (terminal.reader().ready()) {
                int key = terminal.reader().read();
                if (key == 'q') break; // Salir si se presiona 'q'
            }

            String time = sdf.format(new Date());
            terminal.puts(InfoCmp.Capability.cursor_home);
            terminal.writer().println("Press 'q' to exit");
            terminal.writer().println("Time: " + time);
            terminal.writer().println("CPU Usage: " + random.nextInt(100) + "%");
            terminal.writer().println("Memory Usage: " + random.nextInt(100) + "%");
            terminal.writer().println("Disk Usage: " + random.nextInt(100) + "%");
            terminal.writer().println("Network: " + random.nextInt(1000) + " KB/s");

            terminal.flush();
            Thread.sleep(1);
        }

        terminal.writer().println("Exiting...");
        terminal.flush();
        terminal.close();
    }
}

