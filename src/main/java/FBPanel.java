import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FBPanel extends JPanel {
    private JButton nextButton;
    private JButton prevButton;
    private VideoPanel videoPanel;

    public FBPanel(){
        videoPanel = new VideoPanel();
        setLayout(new GridLayout(1,2));
        nextButton = new JButton("Next");
        prevButton = new JButton("Prev");
        add(prevButton);
        add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                videoPanel.getNextFrame();
            }
        });
    }

    public JPanel returnVideoPanel(){
        return videoPanel;
    }
}
