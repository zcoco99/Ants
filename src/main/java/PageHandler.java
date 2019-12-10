import javax.swing.*;
import java.awt.*;

public class PageHandler extends JFrame {

    private boolean flag1;
    private boolean flag2;

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
            add(new LandingPage());
            revalidate();
            repaint();
            UserPage.setUserFlag(false);
        }
        else if(flag2){
            add(new TrackingPage());
            revalidate();
            repaint();
            LandingPage.setLandingFlag(false);
        }
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static JFrame getMainFrame(){
        return mainFrame;
    }
}
