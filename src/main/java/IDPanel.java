import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IDPanel extends JPanel implements ActionListener {

    public IDPanel(){
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //panel.removeAll();
        this.setBackground(Color.green);
        this.add(new JButton("ID 1"));
        this.revalidate();
        this.repaint();
    }
}
