import javax.swing.*;
import java.awt.*;

/*
The VideoFramesContainer class is a JPanel that is used to set the layout of
the frames of the video (VideoPanel) and the forward, backward and submit
buttons (FBPanel)
*/

public class VideoFramesContainer extends JPanel {

    public VideoFramesContainer(){
        setBackground(Color.red);
        setSize(250, 300);

        setBackground(Color.orange);
        setSize(250, 300);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=1;
        c.weighty=6;
        add(new VideoPanel(),c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty=1;
        c.gridx = 0;
        c.gridy = 1;
        add(new FBPanel(), c);
    }
}
