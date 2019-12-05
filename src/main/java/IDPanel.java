import javax.swing.*;
import java.awt.*;

/*
The IDPanel class is a JPanel that contains the ant buttons. When the
user clicks on the + button found in ButtonPanel, a new JButton with
a unique ant ID is created in this panel
*/

public class IDPanel extends JPanel {
    public IDPanel(){
        setLayout(new GridLayout(0,2));     //sets the layout of the ant buttons
    }
}

