import javax.swing.*;
import java.awt.*;

public class FBPanel extends JPanel {
    private JButton for_button;
    private JButton back_button;

    public FBPanel(){
        setLayout(new GridLayout(1,2));
        for_button = new JButton("Next");
        back_button = new JButton("Prev");
        add(back_button);
        add(for_button);
    }
}
