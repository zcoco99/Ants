import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Video menu page: displays 4 video thumbnails for user to choose from.
// display user name, "start labelling" button that leads to the labelling window (Main).

class LandingPage extends JPanel {
    private JLabel header;
    private JButton startButton;
    private static boolean landingFlag;

    public LandingPage() {
        landingFlag = false;
        System.out.println("LandingPage constructor called");
        setSize(500,300);
        setLayout(new GridLayout(0,1));
        header = new JLabel("Choose a Video");

        add(header);
        header.setHorizontalAlignment(JLabel.CENTER);  // center align JLabel header

        add(new MenuVideo());

        startButton = new JButton(("Start Video Labelling"));
        add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TalkServlet.postLanding();
                landingFlag=true;
            }
        });
    }

    public static boolean getLandingFlag(){
        return landingFlag;
    }

    public static void setLandingFlag(boolean state){
        landingFlag = state;
    }
}