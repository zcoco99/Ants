import javax.swing.*;
import java.awt.*;

public class Main {
    static GraphicsConfiguration gc;
    public static void main(String[] args){
        JFrame frame = new JFrame(gc);
        frame.setSize(1000,1000);
        JPanel mainContainer = new JPanel();
        mainContainer.setSize(1000,1000);
        mainContainer.setLayout(new GridLayout(20,10));
        frame.setVisible(true);
        mainContainer.add(new ButtonPanel());
        mainContainer.add(new VideoPanel());
        frame.getContentPane().add(mainContainer);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
