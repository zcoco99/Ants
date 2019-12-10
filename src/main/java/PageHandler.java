import javax.swing.*;
import java.awt.*;

public class PageHandler extends JFrame {
    static JFrame frame3;
    static GraphicsConfiguration gc;

    static JPanel card1 = new JPanel();
    static JPanel card2 = new JPanel();
    static JPanel card3 = new JPanel();
    static JPanel cards;

    private boolean flag1;
    private boolean flag2;
    private boolean flag3;

    static JFrame mainFrame = new JFrame();

    public PageHandler(){
        setSize((new Dimension(500,300)));
        flag1 = UserPage.getUserFlag();
        flag2 = LandingPage.getLandingFlag();
        System.out.println("Flag1: " + flag1);
        System.out.println("Flag2: " + flag2);

        if(!flag1 && !flag2){
            add(new UserPage());
            revalidate();
            repaint();
        }
        else if(flag1){
            //removeAll();
            add(new LandingPage());
            revalidate();
            repaint();
            UserPage.setUserFlag(false);
        }
        else if(flag2){
            //removeAll();
            add(new TrackingPage());
            revalidate();
            repaint();
            LandingPage.setLandingFlag(false);
        }
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*cards = new JPanel(new CardLayout());
        cards.add(card1, new UserPage());
        cards.add(card2, new LandingPage());
        cards.add(card3, new TrackingPage());*/
        /*System.out.println("Page Handler constructor called");
        frame1 = new JFrame(gc);              //Create a new JFrame
        frame1.setSize(500, 300);

        frame1.add(new UserPage());
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame2 = new JFrame(gc);              //Create a new JFrame
        frame2.setSize(500, 300);

        frame2.add(new LandingPage());
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame3 = new JFrame(gc);              //Create a new JFrame
        frame3.setSize(500, 300);

        frame3.add(new TrackingPage());
        frame3.setVisible(true);
        frame3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);*/
    }

    public static JFrame getMainFrame(){
        return mainFrame;
    }
}
