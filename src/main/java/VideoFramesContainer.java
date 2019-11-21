import javax.swing.*;
import java.awt.*;

public class VideoFramesContainer extends JPanel {
    public VideoFramesContainer(){
        setLayout(new GridLayout(2,1));
        setSize(100,100);
        add(new VideoPanel());
        add(new FBPanel());
    }
}
