import javax.swing.*;
import java.awt.*;

public class Main {
    static GraphicsConfiguration gc;
    public static void main(String[] args){
        JFrame frame = new JFrame(gc);
        frame.setSize(1000,800);
        //JPanel mainContainer = new JPanel(new GridBagLayout());
        //GridBagConstraints c = new GridBagConstraints();

        JPanel mainContainer = new JPanel();
        mainContainer.setSize(1000,1000);
        mainContainer.setLayout(new GridLayout(1,2));
        //c.gridx=0;
        //c.gridy=0;
        //c.gridheight=5;
        //c.gridwidth=5;
        //mainContainer.add(new ButtonIDContainer(), c);
        mainContainer.add(new ButtonIDContainer());

        //c.gridx=1;
        //c.gridy=0;
        //c.weightx = 0.5;
        mainContainer.add(new VideoFramesContainer());

        frame.getContentPane().add(mainContainer);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
