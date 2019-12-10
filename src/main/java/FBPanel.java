import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD

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

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) { videoPanel.getPrevFrame(); }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                videoPanel.getNextFrame();
=======
import java.io.IOException;

/*
The FBPanel class is a JPanel that contains 3 buttons:
    1. Forward button to go to next frame of the video
    2. Back button to go to the previous frame of the video
    3. Submit button to submit the data to the servlet
*/

public class FBPanel extends JPanel {
    private JButton nextButton;      //button to go to next frame
    private JButton prevButton;         //button to go to previous frame
    private JButton submitButton;       //submits the ants coordinates
    private VideoPanel videoPanel;
    private static boolean fb;          //false for previous button and true for next button

    public FBPanel(){
        System.out.println("FBPanel constructor called");
        videoPanel = new VideoPanel();
        setLayout(new GridLayout(1,3));
        nextButton = new JButton("Next");
        prevButton = new JButton("Prev");
        submitButton = new JButton("Submit");
        add(prevButton);
        add(nextButton);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            //When submitButton is clicked, submit data to servlet
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TalkServlet.postSubmit();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            //When submitButton is clicked, submit data to servlet
            @Override
            public void actionPerformed(ActionEvent e) {
                //send servlet the current frame and video
                videoPanel.getNextFrame();
                fb=true;
                TalkServlet.postFB();
                //PageHandler.getFrame3().setVisible(true);
            }
        });

        prevButton.addActionListener(new ActionListener() {
            //When submitButton is clicked, submit data to servlet
            @Override
            public void actionPerformed(ActionEvent e) {
                //send servlet the current frame and video
                videoPanel.getPrevFrame();
                fb=false;
                TalkServlet.postFB();
                //PageHandler.getFrame3().setVisible(false);
                //PageHandler.getFrame2().setVisible(true);
>>>>>>> temp
            }
        });
    }

<<<<<<< HEAD
    public JPanel returnVideoPanel(){
=======
    public static boolean getFBState(){
        return fb;
    }

    public VideoPanel returnVideoPanel(){
>>>>>>> temp
        return videoPanel;
    }
}