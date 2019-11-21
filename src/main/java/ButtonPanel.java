import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton add_button;
    private JButton minus_button;

    public ButtonPanel(){
        setLayout(new GridLayout(1,2));
        add_button = new JButton("+");
        minus_button = new JButton("-");
        add(add_button);
        add(minus_button);
    }
}
