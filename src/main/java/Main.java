import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        Username obj = new Username();
        System.out.println("Click status: " + VideoMenu.startClick());
        boolean flag = true;
            while(obj.isActive() && flag){
                if (VideoMenu.startClick()){
                    flag = false;
                    GridBagConstraints c = new GridBagConstraints();
                    c.fill = GridBagConstraints.BOTH;
                    c.gridx = 0;
                    c.gridy = 0;
                    c.weightx= 1;
                    c.weighty= 1;
                    obj.getContentPane().removeAll();
                    obj.add(new MainPage(),c);
                    obj.revalidate();
                    obj.repaint();
            }
        }
    }  //ASK FOR USER NAME
}

