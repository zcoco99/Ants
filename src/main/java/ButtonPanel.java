import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton button1;
    private JButton button2;

    public ButtonPanel(){
        button1 = new JButton("+");
        button2 = new JButton("-");

        setLayout(new GridLayout(1,2));
        add(button1);
        add(button2);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ID added");
                //Add a button to ID panel
                JButton buttonID = new JButton("ID 1");
                //idPanel.add();
                //IDPanel.add();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ID removed");
            }
        });
    }
}
