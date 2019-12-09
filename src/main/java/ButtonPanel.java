import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton addButton;
    private JButton minusButton;

    public ButtonPanel(){
        addButton = new JButton("+");
        minusButton = new JButton("-");

        setLayout(new GridLayout(1,2));
        addButton = new JButton("+");
        minusButton = new JButton("-");
        add(addButton);
        add(minusButton);
    }
}
