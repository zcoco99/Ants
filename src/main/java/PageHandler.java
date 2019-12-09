import javax.swing.*;
import java.awt.*;

public class PageHandler extends JFrame {
    static JFrame frame3;
    static JFrame frame1;
    static JFrame frame2;
    static GraphicsConfiguration gc;

    public PageHandler(){
        frame1 = new JFrame(gc);              //Create a new JFrame
        frame1.setSize(500, 300);

        frame1.add(new UserPage());
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame2 = new JFrame(gc);              //Create a new JFrame
        frame2.setSize(500, 300);

        frame2.add(new LandingPage());
        frame2.setVisible(false);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame3 = new JFrame(gc);              //Create a new JFrame
        frame3.setSize(500, 300);

        frame3.add(new TrackingPage());
        frame3.setVisible(false);
        frame3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static JFrame getFrame3(){
        return frame3;
    }

    public static JFrame getFrame1(){
        return frame1;
    }

    public static JFrame getFrame2(){
        return frame2;
    }
}
