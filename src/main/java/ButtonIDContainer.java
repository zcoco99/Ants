import javax.swing.*;
import java.awt.*;

public class ButtonIDContainer extends JPanel {
    public ButtonIDContainer(){
        setSize(50,100);
        setLayout(new GridLayout(2,1));
        add(new ButtonPanel());
        add(new IDPanel());
    }
}
