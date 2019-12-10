import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Video menu page: displays 4 video thumbnails for user to choose from.
// display user name, "start labelling" button that leads to the labelling window (Main).

class VideoMenu extends JPanel {
    // public variables
    private JLabel header;
    private JButton startLabel;
    private static boolean flag;

    public VideoMenu() // pass on the username
    {
        setSize(600,500);
        setLayout(new GridBagLayout());
        header = new JLabel("Choose a Video");

        //==== "Start labelling" button ====

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

        startLabel = new JButton(("Start Video Labelling"));

        c.gridx = 0;
        c.gridy = 7;
        c.weightx=1;
        c.weighty=1;
        add(startLabel,c);

        flag = false;
        startLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                flag=true;
            }
        });

    }

    public static boolean startClick(){
        System.out.println("startClick() called");
        return flag;
    }
}
