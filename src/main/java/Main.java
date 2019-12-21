import panels.*;

import java.awt.*;

/*
The Main class is used to create a JFrame which has the main container
for holding the panels.ButtonIDContainer and panels.VideoFramesContainer
*/

public class Main {
<<<<<<< HEAD
    public static void main(String[] args){
        Username obj = new Username();
        System.out.println("Click status: " + VideoMenu.startClick());
        boolean flag = true;
            while(obj.isActive() && flag){
                if (VideoMenu.startClick()){
                    flag = false;
                    GridBagConstraints c = new GridBagConstraints();
                    c.fill = GridBagConstraints.BOTH;
                    c.gridx = 0;
                    c.gridy = 0;
                    c.weightx= 1;
                    c.weighty= 1;
                    obj.getContentPane().removeAll();
                    obj.add(new MainPage(),c);
                    obj.revalidate();
                    obj.repaint();
            }
        }
    }  //ASK FOR USER NAME
=======
    static GraphicsConfiguration gc;

    public static void main(String[] args) {
        PageHandler pageHandler = new PageHandler();
        pageHandler.add(new UserPage());
        pageHandler.revalidate();
        pageHandler.repaint();

        while(pageHandler.isActive()){
            boolean flag1 = UserPage.getUserFlag();
            boolean flag2 = LandingPage.getLandingFlag();
            boolean flag3 = ButtonPanel.getBackFlag();

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
            else if(flag3){
                pageHandler.getContentPane().removeAll();
                pageHandler.add(new LandingPage());
                pageHandler.revalidate();
                pageHandler.repaint();
                ButtonPanel.setBackFlag(false);
            }
        }
    }
>>>>>>> temp
}

