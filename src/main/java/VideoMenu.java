import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Video menu page: displays 4 video thumbnails for user to choose from.
// display user name, "start labelling" button that leads to the labelling window (Main).

class VideoMenu extends JFrame {
    // public variables
    JLabel header;
    JButton startlabel;

    public VideoMenu(String username) // pass on the username
    {
        header = new JLabel("Choose a Video");
        //==== "Start labelling" button ====
        startlabel = new JButton(("Start Video Labelling"));
        startlabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(username);  // print user input on terminal
                new Main();  // open up video labelling window
            }
        });

        // add components
        add(header);
        add(new MenuList());  // add the video list grid
        add(startlabel);


        // frame settings
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
