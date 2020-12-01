import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        int width=600;
        int height=600;
        MainFrame frame = new MainFrame(width,height);
        frame.setTitle("Paint");
        frame.setSize(width, height);
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.createBufferStrategy(2);
    }
}
