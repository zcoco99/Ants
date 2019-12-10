import javax.swing.*;
import java.awt.*;

/*
The Main class is used to create a JFrame which has the main container
for holding the ButtonIDContainer and VideoFramesContainer
*/

public class Main {
    static GraphicsConfiguration gc;

    public static void main(String[] args) {
        PageHandler pageHandler = new PageHandler();
        pageHandler.add(new UserPage());
        pageHandler.revalidate();
        pageHandler.repaint();

        while(pageHandler.isActive()){
            boolean flag1 = UserPage.getUserFlag();
            boolean flag2 = LandingPage.getLandingFlag();

            if(flag1){
                pageHandler.getContentPane().removeAll();
                pageHandler.add(new LandingPage());
                pageHandler.revalidate();
                pageHandler.repaint();
                UserPage.setUserFlag(false);
            }
            else if(flag2){
                pageHandler.getContentPane().removeAll();
                pageHandler.add(new TrackingPage());
                pageHandler.revalidate();
                pageHandler.repaint();
                LandingPage.setLandingFlag(false);
            }
        }
    }
}
