import javax.swing.*;
import java.awt.*;

public class ButtonIDContainer extends JPanel {
    private IDPanel idPanel;

    public ButtonIDContainer(){
        idPanel = new IDPanel();
        setSize(50,100);
        setLayout(new GridLayout(2,1));
        add(new ButtonPanel());
        idPanel = (IDPanel) ButtonPanel.idPanelReturn();
        add(idPanel);
    }
}
