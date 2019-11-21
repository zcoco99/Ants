import javax.swing.*;
import java.awt.*;

public class VideoPanel extends JPanel {
    private JPanel videoPanel;

    public VideoPanel(){
        videoPanel = new JPanel();
        setSize(100,100);
        setBackground(Color.black);
        add(videoPanel);
    }
}
