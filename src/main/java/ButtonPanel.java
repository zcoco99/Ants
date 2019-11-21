import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton button1;
    private JButton button2;

    public ButtonPanel(){
        button1 = new JButton("+");
        button2 = new JButton("-");
        setLayout(new GridLayout(1,2));

        Dimension d = new Dimension(500,500);
        //button1.setSize(d);
        //button2.setSize(d);
        add(button1);
        add(button2);

    }
}
