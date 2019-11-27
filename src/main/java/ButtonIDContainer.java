import javax.swing.*;
import java.awt.*;

public class ButtonIDContainer extends JPanel {
    private IDPanel idPanel;

    public ButtonIDContainer(){
        idPanel = new IDPanel();
        idPanel = (IDPanel) ButtonPanel.idPanelReturn();
        setBackground(Color.orange);
        setSize(250, 300);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=1;
        c.weighty=1;
        add(new ButtonPanel(),c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty=6;
        c.gridx = 0;
        c.gridy = 1;
        add(idPanel, c);
    }
}
