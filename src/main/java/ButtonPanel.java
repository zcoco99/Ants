import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton addButton;
    private JButton minusButton;

    public ButtonPanel(){
        setLayout(new GridLayout(1,2));
        addButton = new JButton("+");
        minusButton = new JButton("-");
        add(addButton);
        add(minusButton);
    }
}
