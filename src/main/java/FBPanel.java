import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
The FBPanel class is a JPanel that contains 3 buttons:
    1. Forward button to go to next frame of the video
    2. Back button to go to the previous frame of the video
    3. Submit button to submit the data to the servlet
*/

public class FBPanel extends JPanel {
    private JButton forwardButton;      //button to go to next frame
    private JButton backButton;         //button to go to previous frame
    private JButton submitButton;       //submits the ants coordinates
    private JPanel videoPanel;

    public FBPanel(){
        videoPanel = new VideoPanel();

        setLayout(new GridLayout(1,3));
        forwardButton = new JButton("Next");
        backButton = new JButton("Prev");
        submitButton = new JButton("Submit");
        add(backButton);
        add(forwardButton);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            //When submitButton is clicked, submit data to servlet
            @Override
            public void actionPerformed(ActionEvent e) {
                new TalkServlet();
            }
        });
    }
}
