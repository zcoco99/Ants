import javax.swing.*;
import java.awt.*;

// Class Main() is a new JFrame with the main ant video labelling functions

public class MainPage extends JPanel{
     // Class field containing config info
    public MainPage(){

        //JFrame frame = new JFrame(gc); // Create a new JFrame
        setSize(600, 500);
        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=1;
        c.weighty=1;
        mainContainer.add(new ButtonIDContainer(),c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx=4;
        c.weighty=1;
        mainContainer.add(new VideoFramesContainer(),c);

        add(mainContainer);
        setVisible(true);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
