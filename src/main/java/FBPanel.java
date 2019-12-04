import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FBPanel extends JPanel {
    private JButton for_button;
    private JButton back_button;
    private JButton submitButton;
    private ArrayList<ArrayList<Integer>> antData;
    private JPanel videoPanel;

    public FBPanel(){
        videoPanel = new VideoPanel();
        antData = new ArrayList<ArrayList<Integer>>();

        setLayout(new GridLayout(1,2));
        for_button = new JButton("Next");
        back_button = new JButton("Prev");
        submitButton = new JButton("Submit");
        add(back_button);
        add(for_button);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                antData = VideoPanel.antDataReturn();
                //System.out.println("antdata: ");
                //System.out.println(antData);
            }
        });
    }
}
