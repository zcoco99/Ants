import javax.swing.*;
import java.awt.*;

public class Main {
    static GraphicsConfiguration gc; // Class field containing config info

    public static void main(String[] args) {
        JFrame frame = new JFrame(gc); // Create a new JFrame
        frame.setSize(500, 300);
        JPanel mainContainer = new JPanel();

        mainContainer.setLayout(new GridLayout(1,2));

        mainContainer.add(new ButtonIDContainer());
        mainContainer.add(new VideoFramesContainer());
        frame.add(mainContainer);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}