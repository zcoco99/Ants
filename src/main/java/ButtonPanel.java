import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonPanel extends JPanel {
    private JButton addButton;
    private JButton minusButton;
    private JButton lastButton;
    static IDPanel idPanel = new IDPanel();
    private ArrayList<JButton> antList;

    private int count=0;

    public ButtonPanel(){
        antList = new ArrayList<JButton>();
        addButton = new JButton("+");
        minusButton = new JButton("-");

        setLayout(new GridLayout(1,2));
        add(addButton);
        add(minusButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                JButton btn = new JButton("ID" + count);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        lastButton = btn;
                    }
                });
                idPanel.add(btn);
                idPanel.revalidate();
                idPanel.repaint();
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lastButton != null){
                    lastButton.getParent().remove(lastButton);
                    idPanel.revalidate();
                    idPanel.repaint();
                }
                lastButton = null;
            }
        });
    }

    public static JPanel idPanelReturn(){
        return idPanel;
    }
}