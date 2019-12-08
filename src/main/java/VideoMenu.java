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
        setLayout(new GridBagLayout());

        header = new JLabel("Choose a Video");

        //==== "Start labelling" button ====
        startlabel = new JButton(("Start Video Labelling"));
        startlabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // new username.nameReturn();  // print user input on terminal
                new Main();  // open up video labelling window
            }
        });

        // add components
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=1;
        c.weighty=1;
        add(header ,c);
        header.setHorizontalAlignment(JLabel.CENTER);  // center align JLabel header

        c.gridx = 0;
        c.gridy = 2;
        c.weightx=1;
        c.weighty=4;
        add(new MenuList(),c);  // add the video list grid

        c.gridx = 0;
        c.gridy = 7;
        c.weightx=1;
        c.weighty=1;
        add(startlabel,c);


        // frame settings
        //setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
