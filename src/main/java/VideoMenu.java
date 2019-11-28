import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VideoMenu extends JFrame {
    // public variables
    JLabel header;
    JButton startlabel;

    public VideoMenu()
    {
        header = new JLabel("Choose a Video");

        //==== "Start labelling" button ====
        startlabel = new JButton(("Start Video Labelling"));
        startlabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Main();  // open up video labelling window
            }
        });

        // add components
        add(header);
        add(startlabel);


        // frame settings
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
