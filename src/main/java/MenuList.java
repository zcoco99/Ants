import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

// GridbagLayout for 4 video thumbnails
public class MenuList extends JPanel{
    private GridBagLayout vidlist; //video list
    private JButton vid1, vid2, vid3, vid4;
    int vidID;


    public MenuList(){
        setLayout(new GridBagLayout());

        vid1 = new JButton("video 1");
        vid2 = new JButton("video 2");
        vid3 = new JButton("video 3");
        vid4 = new JButton("video 4");

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=1;
        c.weighty=1;
        add(vid1 ,c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx=1;
        c.weighty=1;
        add(vid2 ,c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx=1;
        c.weighty=1;
        add(vid3 ,c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx=1;
        c.weighty=1;
        add(vid4 ,c);

        setSize(200,200);

        // Add button actions : return videoID
        vid1.addActionListener(actionEvent -> {

        });


    }

}
